package com.dxc.hib;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class EmployCrud {

	public String updateEmploy(Employ employ) {
		SessionFactory sf = SessionHelper.getFactory();
		Session s = sf.openSession();
		Employ res = searchEmploy(employ.getEmpno());
		if (res!=null) {
			Transaction t =s.beginTransaction();
			res.setName(employ.getName());
			res.setDept(employ.getDept());
			res.setDesig(employ.getDesig());
			res.setBasic(employ.getBasic());
			s.update(res);
			t.commit();
			return "Record Updated...";
		} else {
			return "Employ No Not Found...";
		}
	}
	public String deleteEmploy(int empno) {
		SessionFactory sf = SessionHelper.getFactory();
		Session s = sf.openSession();
		Employ employ = searchEmploy(empno);
		if (employ!=null) {
			Transaction t =s.beginTransaction();
			s.delete(employ);
			t.commit();
			return "Record Deleted...";
		} else {
			return "Record Not Found...";
		}
	}
	public String addEmploy(Employ employ) {
		SessionFactory sf = SessionHelper.getFactory();
		Session s = sf.openSession();
		Transaction t =s.beginTransaction();
		s.save(employ);
		t.commit();
		return "Record Added...";
	}
	public Employ searchEmploy(int empno) {
		SessionFactory sf = SessionHelper.getFactory();
		Session s = sf.openSession();
		Query q = s.createQuery("from Employ where empno=" +empno);
		List<Employ> employs = q.list();
		Employ employ = null;
		if (employs.size() != 0) {
			employ = employs.get(0);
		}
		return employ;
	}
	public Employ[] showEmploy() {
		SessionFactory sf = SessionHelper.getFactory();
		Session s = sf.openSession();
		Query q = s.createQuery("from Employ");
		List<Employ> employList = q.list();
		Employ[] employs = employList.toArray(new Employ[employList.size()]);
		return employs;
	}
}
