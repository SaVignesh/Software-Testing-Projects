package api.endpoints;

public class URLs {
	public static String base_url = "https://petstore.swagger.io/v2";
	
	//User Module
	public static String user_post_url = base_url + "/user";
	public static String user_get_url = base_url + "/user/{username}";
	public static String user_update_url = base_url + "/user/{username}";
	public static String user_delete_url = base_url + "/user/{username}";
	
	//Store Module
	public static String store_post_url = base_url + "/store/order";
	public static String store_get_url = base_url + "/store/order/{orderID}";
	public static String store_delete_url = base_url + "/store/order/{orderID}";
	
	

}
