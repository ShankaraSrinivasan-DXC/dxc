package com.dxc.clientDemo;

public class HelloProxy implements com.dxc.clientDemo.Hello {
  private String _endpoint = null;
  private com.dxc.clientDemo.Hello hello = null;
  
  public HelloProxy() {
    _initHelloProxy();
  }
  
  public HelloProxy(String endpoint) {
    _endpoint = endpoint;
    _initHelloProxy();
  }
  
  private void _initHelloProxy() {
    try {
      hello = (new com.dxc.clientDemo.HelloServiceLocator()).getHello();
      if (hello != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)hello)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)hello)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (hello != null)
      ((javax.xml.rpc.Stub)hello)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.dxc.clientDemo.Hello getHello() {
    if (hello == null)
      _initHelloProxy();
    return hello;
  }
  
  public java.lang.String sayHello() throws java.rmi.RemoteException{
    if (hello == null)
      _initHelloProxy();
    return hello.sayHello();
  }
  
  
}