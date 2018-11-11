package com.tarena.web.action.order;

import java.util.List;

import com.tarena.dao.IAddressDao;
import com.tarena.dao.impl.AddressDaoImpl;
import com.tarena.entity.Address;
import com.tarena.entity.User;
import com.tarena.web.action.BaseAction;

public class AddressFormAction extends BaseAction{
		private Address address;
		private IAddressDao dao = new AddressDaoImpl();
		public String execute(){
			User user = (User)session.get("user");
			try {
				List<Address> addresses = dao.findAddressByUserId(user.getId());
				if(addresses!=null&&addresses.size()>=1){
					address = addresses.get(0);
				}else{
					address = new Address();
				}
				return "address_form";
			} catch (Exception e) {
				e.printStackTrace();
				return "error";
			}
		}
		public Address getAddress() {
			return address;
		}
		public void setAddress(Address address) {
			this.address = address;
		}
		
}