package api.endpoints;




//swagger url-->https://petstore.swagger.io
//create user(post)-https://petstore.swagger.io/v2/user  
//get user (get)-https://petstore.swagger.io/v2/user/{username}
//Update User(put)-https://petstore.swagger.io/v2/user/{username}
//Delete user(delete)-https://petstore.swagger.io/v2/user/{username} 
public class Routes {

	public static String base_url="https://petstore.swagger.io/v2";
	
	//User Module
	public static String post_url=base_url+"/user";
	public static String get_url=base_url+"/user/{username}";
	public static String update_url=base_url+"/user/{username}";
	public static String delete_url=base_url+"/user/{username}";
	
	//Store module
	public static String Post_url=base_url+"/store/order";
	public static String Get_url=base_url+"/store/order/{PetId}";
	public static String Updatae_url=base_url+"/store/order/{orderId}";
	public static String Delete_url=base_url+"/store/order/{orderId}";
	         //here you will create store module URL,s
	
	//pet module
	public static String postp_url=base_url+"/pet";
	public static String getp_url=base_url+"/pet/{petId}";
	public static String updatep_url=base_url+"/pet/{petId}";
	public static String deletep_url=base_url+"/pet/{petId}";
	
	     //here you will create pet module URL,s
}
