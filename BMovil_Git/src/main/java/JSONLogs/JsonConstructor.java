package JSONLogs;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.IOUtils;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.codehaus.jettison.json.JSONTokener;

public class JsonConstructor {
	
	
	public static void createJsonInstrument1Prod(String numeroCelular){
		JSONObject jo;
		try 
		{
			jo = (JSONObject) new JSONTokener(IOUtils.toString(new URL("https://www.bancomermovil.com/bm3wxp_mx_web/servlet/ServletOperacionWeb?OPERACION=BAN2O05&LOCALE=es_ES&PAR_INICIO.0={\"operacion\":\"consultaEstatusMantenimiento\",\"verCatTelefonicas\":\"0\",\"verCatAutenticacion\":\"0\",\"numeroTelefono\":\""+numeroCelular+"\",\"VM\":\"100\"}"))).nextValue();
			jo.remove("autenticacion");
			jo.remove("telefonicasMantenimiento");
			jo.remove("ocNotificaciones");
			LogResultInstrument1.setEstado(jo.getString("estado"));
			LogResultInstrument1.setNumeroCliente(jo.getString("numeroCliente"));
			LogResultInstrument1.setEstatusServicio(jo.getString("estatusServicio"));
			LogResultInstrument1.setCompaniaCelular(jo.getString("companiaCelular"));
			LogResultInstrument1.setFechaContratacion(jo.getString("fechaContratacion"));
			LogResultInstrument1.setFechaSistema(jo.getString("fechaSistema"));
			LogResultInstrument1.setPerfilCliente(jo.getString("perfilCliente"));
			LogResultInstrument1.setTipoInstrumento(jo.getString("tipoInstrumento"));
			LogResultInstrument1.setEstatusInstrumento(jo.getString("estatusInstrumento"));
			LogResultInstrument1.setEmailCliente(jo.getString("emailCliente"));
			LogResultInstrument1.setNombreCliente(jo.getString("nombreCliente"));
			LogResultInstrument1.setEstatusAlertas(jo.getString("estatusAlertas"));
			LogResultInstrument1.setSwitchEnrolamiento(jo.getString("switchEnrolamiento"));
			LogResultInstrument1.setCadenaJson(jo.toString());
			
			System.out.println("Json Log creado con éxito");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void createJsonInstrument2Prod(String numeroCelular){
		JSONObject jo;
		try 
		{
			jo = (JSONObject) new JSONTokener(IOUtils.toString(new URL("https://www.bancomermovil.com/bm3wxp_mx_web/servlet/ServletOperacionWeb?OPERACION=BAN2O05&LOCALE=es_ES&PAR_INICIO.0={\"operacion\":\"consultaEstatusMantenimiento\",\"verCatTelefonicas\":\"0\",\"verCatAutenticacion\":\"0\",\"numeroTelefono\":\""+numeroCelular+"\",\"VM\":\"100\"}"))).nextValue();
			jo.remove("autenticacion");
			jo.remove("telefonicasMantenimiento");
			jo.remove("ocNotificaciones");
			LogResultInstrument2.setEstado(jo.getString("estado"));
			LogResultInstrument2.setNumeroCliente(jo.getString("numeroCliente"));
			LogResultInstrument2.setEstatusServicio(jo.getString("estatusServicio"));
			LogResultInstrument2.setCompaniaCelular(jo.getString("companiaCelular"));
			LogResultInstrument2.setFechaContratacion(jo.getString("fechaContratacion"));
			LogResultInstrument2.setFechaSistema(jo.getString("fechaSistema"));
			LogResultInstrument2.setPerfilCliente(jo.getString("perfilCliente"));
			LogResultInstrument2.setTipoInstrumento(jo.getString("tipoInstrumento"));
			LogResultInstrument2.setEstatusInstrumento(jo.getString("estatusInstrumento"));
			LogResultInstrument2.setEmailCliente(jo.getString("emailCliente"));
			LogResultInstrument2.setNombreCliente(jo.getString("nombreCliente"));
			LogResultInstrument2.setEstatusAlertas(jo.getString("estatusAlertas"));
			LogResultInstrument2.setSwitchEnrolamiento(jo.getString("switchEnrolamiento"));
			LogResultInstrument2.setCadenaJson(jo.toString());
			
			System.out.println("Json Log creado con éxito");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void createJsonInstrument3Prod(String numeroCelular){
		JSONObject jo;
		try 
		{
			jo = (JSONObject) new JSONTokener(IOUtils.toString(new URL("https://www.bancomermovil.com/bm3wxp_mx_web/servlet/ServletOperacionWeb?OPERACION=BAN2O05&LOCALE=es_ES&PAR_INICIO.0={\"operacion\":\"consultaEstatusMantenimiento\",\"verCatTelefonicas\":\"0\",\"verCatAutenticacion\":\"0\",\"numeroTelefono\":\""+numeroCelular+"\",\"VM\":\"100\"}"))).nextValue();
			jo.remove("autenticacion");
			jo.remove("telefonicasMantenimiento");
			jo.remove("ocNotificaciones");
			LogResultInstrument3.setEstado(jo.getString("estado"));
			LogResultInstrument3.setNumeroCliente(jo.getString("numeroCliente"));
			LogResultInstrument3.setEstatusServicio(jo.getString("estatusServicio"));
			LogResultInstrument3.setCompaniaCelular(jo.getString("companiaCelular"));
			LogResultInstrument3.setFechaContratacion(jo.getString("fechaContratacion"));
			LogResultInstrument3.setFechaSistema(jo.getString("fechaSistema"));
			LogResultInstrument3.setPerfilCliente(jo.getString("perfilCliente"));
			LogResultInstrument3.setTipoInstrumento(jo.getString("tipoInstrumento"));
			LogResultInstrument3.setEstatusInstrumento(jo.getString("estatusInstrumento"));
			LogResultInstrument3.setEmailCliente(jo.getString("emailCliente"));
			LogResultInstrument3.setNombreCliente(jo.getString("nombreCliente"));
			LogResultInstrument3.setEstatusAlertas(jo.getString("estatusAlertas"));
			LogResultInstrument3.setSwitchEnrolamiento(jo.getString("switchEnrolamiento"));
			LogResultInstrument3.setCadenaJson(jo.toString());
			
			System.out.println("Json Log creado con éxito");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void createJsonInstrumentTest1(String numeroCelular){
		JSONObject jo;
		try 
		{
			jo = (JSONObject) new JSONTokener(IOUtils.toString(new URL("https://www.bancomermovil.net:11443/bm3wxd_mx_web/servlet/ServletOperacionWeb?OPERACION=BAN2O05&LOCALE=es_ES&PAR_INICIO.0={\"operacion\":\"consultaEstatusMantenimiento\",\"verCatTelefonicas\":\"0\",\"verCatAutenticacion\":\"0\",\"numeroTelefono\":\""+numeroCelular+"\",\"VM\":\"100\"}"))).nextValue();
			jo.remove("autenticacion");
			jo.remove("telefonicasMantenimiento");
			jo.remove("ocNotificaciones");
			LogResultInstrument1.setEstado(jo.getString("estado"));
			LogResultInstrument1.setNumeroCliente(jo.getString("numeroCliente"));
			LogResultInstrument1.setEstatusServicio(jo.getString("estatusServicio"));
			LogResultInstrument1.setCompaniaCelular(jo.getString("companiaCelular"));
			LogResultInstrument1.setFechaContratacion(jo.getString("fechaContratacion"));
			LogResultInstrument1.setFechaSistema(jo.getString("fechaSistema"));
			LogResultInstrument1.setPerfilCliente(jo.getString("perfilCliente"));
			LogResultInstrument1.setTipoInstrumento(jo.getString("tipoInstrumento"));
			LogResultInstrument1.setEstatusInstrumento(jo.getString("estatusInstrumento"));
			LogResultInstrument1.setEmailCliente(jo.getString("emailCliente"));
			LogResultInstrument1.setNombreCliente(jo.getString("nombreCliente"));
			LogResultInstrument1.setEstatusAlertas(jo.getString("estatusAlertas"));
			LogResultInstrument1.setSwitchEnrolamiento(jo.getString("switchEnrolamiento"));
			LogResultInstrument1.setCadenaJson(jo.toString());
			
			System.out.println("Json Log creado con éxito");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public static void createJsonInstrumentTest2(String numeroCelular){
		JSONObject jo;
		try 
		{
			jo = (JSONObject) new JSONTokener(IOUtils.toString(new URL("https://www.bancomermovil.net:11443/bm3wxd_mx_web/servlet/ServletOperacionWeb?OPERACION=BAN2O05&LOCALE=es_ES&PAR_INICIO.0={\"operacion\":\"consultaEstatusMantenimiento\",\"verCatTelefonicas\":\"0\",\"verCatAutenticacion\":\"0\",\"numeroTelefono\":\""+numeroCelular+"\",\"VM\":\"100\"}"))).nextValue();
			jo.remove("autenticacion");
			jo.remove("telefonicasMantenimiento");
			jo.remove("ocNotificaciones");
			LogResultInstrument2.setEstado(jo.getString("estado"));
			LogResultInstrument2.setNumeroCliente(jo.getString("numeroCliente"));
			LogResultInstrument2.setEstatusServicio(jo.getString("estatusServicio"));
			LogResultInstrument2.setCompaniaCelular(jo.getString("companiaCelular"));
			LogResultInstrument2.setFechaContratacion(jo.getString("fechaContratacion"));
			LogResultInstrument2.setFechaSistema(jo.getString("fechaSistema"));
			LogResultInstrument2.setPerfilCliente(jo.getString("perfilCliente"));
			LogResultInstrument2.setTipoInstrumento(jo.getString("tipoInstrumento"));
			LogResultInstrument2.setEstatusInstrumento(jo.getString("estatusInstrumento"));
			LogResultInstrument2.setEmailCliente(jo.getString("emailCliente"));
			LogResultInstrument2.setNombreCliente(jo.getString("nombreCliente"));
			LogResultInstrument2.setEstatusAlertas(jo.getString("estatusAlertas"));
			LogResultInstrument2.setSwitchEnrolamiento(jo.getString("switchEnrolamiento"));
			LogResultInstrument2.setCadenaJson(jo.toString());
			
			System.out.println("Json Log creado con éxito");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void createJsonInstrumentTest3(String numeroCelular){
		JSONObject jo;
		try 
		{
			jo = (JSONObject) new JSONTokener(IOUtils.toString(new URL("https://www.bancomermovil.net:11443/bm3wxd_mx_web/servlet/ServletOperacionWeb?OPERACION=BAN2O05&LOCALE=es_ES&PAR_INICIO.0={\"operacion\":\"consultaEstatusMantenimiento\",\"verCatTelefonicas\":\"0\",\"verCatAutenticacion\":\"0\",\"numeroTelefono\":\""+numeroCelular+"\",\"VM\":\"100\"}"))).nextValue();
			jo.remove("autenticacion");
			jo.remove("telefonicasMantenimiento");
			jo.remove("ocNotificaciones");
			LogResultInstrument3.setEstado(jo.getString("estado"));
			LogResultInstrument3.setNumeroCliente(jo.getString("numeroCliente"));
			LogResultInstrument3.setEstatusServicio(jo.getString("estatusServicio"));
			LogResultInstrument3.setCompaniaCelular(jo.getString("companiaCelular"));
			LogResultInstrument3.setFechaContratacion(jo.getString("fechaContratacion"));
			LogResultInstrument3.setFechaSistema(jo.getString("fechaSistema"));
			LogResultInstrument3.setPerfilCliente(jo.getString("perfilCliente"));
			LogResultInstrument3.setTipoInstrumento(jo.getString("tipoInstrumento"));
			LogResultInstrument3.setEstatusInstrumento(jo.getString("estatusInstrumento"));
			LogResultInstrument3.setEmailCliente(jo.getString("emailCliente"));
			LogResultInstrument3.setNombreCliente(jo.getString("nombreCliente"));
			LogResultInstrument3.setEstatusAlertas(jo.getString("estatusAlertas"));
			LogResultInstrument3.setSwitchEnrolamiento(jo.getString("switchEnrolamiento"));
			LogResultInstrument3.setCadenaJson(jo.toString());
			
			System.out.println("Json Log creado con éxito");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void createJsonEnrolamientoProd(String numeroCelular){
		JSONObject jo;
		try 
		{
			jo = (JSONObject) new JSONTokener(IOUtils.toString(new URL("https://www.bancomermovil.com/prmbmv_mx_web/mbmv_mult_web_mbmv_01/services/ctrl/V05/allowed?cellphone="+numeroCelular))).nextValue();
			LogResultEnrolamiento.setCadenaJson(jo.toString());
			JSONArray jArray = jo.getJSONArray("allowedList");
			jo = jArray.getJSONObject(0);
			LogResultEnrolamiento.setConvivencia(jo.getString("value"));
			jo = jArray.getJSONObject(1);
			LogResultEnrolamiento.setSSO(jo.getString("value"));
			jo = jArray.getJSONObject(2);
			LogResultEnrolamiento.setBiometric(jo.getString("value"));
			jo = jArray.getJSONObject(3);
			LogResultEnrolamiento.setEDOCUENTA(jo.getString("value"));
			jo = jArray.getJSONObject(4);
			LogResultEnrolamiento.setIsNewTC(jo.getString("value"));
			jo = jArray.getJSONObject(5);
			LogResultEnrolamiento.setFecha(jo.getString("value"));
			jo = jArray.getJSONObject(6);
			LogResultEnrolamiento.setEnrollSTS(jo.getString("value"));
			jo = jArray.getJSONObject(7);
			LogResultEnrolamiento.setCHATLP(jo.getString("value"));
			jo = jArray.getJSONObject(8);
			LogResultEnrolamiento.setFIRMA(jo.getString("value"));
			jo = jArray.getJSONObject(9);
			LogResultEnrolamiento.setAPX(jo.getString("value"));
			jo = jArray.getJSONObject(10);
			LogResultEnrolamiento.setTokenIOS(jo.getString("value"));
			jo = jArray.getJSONObject(11);
			LogResultEnrolamiento.setMigrationProfile(jo.getString("value"));
			jo = jArray.getJSONObject(12);
			LogResultEnrolamiento.setIVREnroll(jo.getString("value"));
			jo = jArray.getJSONObject(13);
			LogResultEnrolamiento.setApxbackend(jo.getString("value"));
			jo = jArray.getJSONObject(14);
			LogResultEnrolamiento.setSSO2(jo.getString("value"));
			jo = jArray.getJSONObject(15);
			LogResultEnrolamiento.setLDAPUser(jo.getString("value"));
			jo = jArray.getJSONObject(16);
			LogResultEnrolamiento.setEnrollBiometrico(jo.getString("value"));
			jo = jArray.getJSONObject(17);
			LogResultEnrolamiento.setIsArco(jo.getString("value"));
			
			System.out.println("Json Log creado con éxito");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void createJsonEnrolamientoTest(String numeroCelular){
		JSONObject jo;
		try 
		{
			jo = (JSONObject) new JSONTokener(IOUtils.toString(new URL("https://www.bancomermovil.net:11443/dembmv_mx_web/mbmv_mult_web_mbmv_01/services/ctrl/V05/allowed?cellphone="+numeroCelular))).nextValue();
			LogResultEnrolamiento.setCadenaJson(jo.toString());
			JSONArray jArray = jo.getJSONArray("allowedList");
			jo = jArray.getJSONObject(0);
			LogResultEnrolamiento.setConvivencia(jo.getString("value"));
			jo = jArray.getJSONObject(1);
			LogResultEnrolamiento.setSSO(jo.getString("value"));
			jo = jArray.getJSONObject(2);
			LogResultEnrolamiento.setBiometric(jo.getString("value"));
			jo = jArray.getJSONObject(3);
			LogResultEnrolamiento.setEDOCUENTA(jo.getString("value"));
			jo = jArray.getJSONObject(4);
			LogResultEnrolamiento.setIsNewTC(jo.getString("value"));
			jo = jArray.getJSONObject(5);
			LogResultEnrolamiento.setFecha(jo.getString("value"));
			jo = jArray.getJSONObject(6);
			LogResultEnrolamiento.setEnrollSTS(jo.getString("value"));
			jo = jArray.getJSONObject(7);
			LogResultEnrolamiento.setCHATLP(jo.getString("value"));
			jo = jArray.getJSONObject(8);
			LogResultEnrolamiento.setFIRMA(jo.getString("value"));
			jo = jArray.getJSONObject(9);
			LogResultEnrolamiento.setAPX(jo.getString("value"));
			jo = jArray.getJSONObject(10);
			LogResultEnrolamiento.setTokenIOS(jo.getString("value"));
			jo = jArray.getJSONObject(11);
			LogResultEnrolamiento.setMigrationProfile(jo.getString("value"));
			jo = jArray.getJSONObject(12);
			LogResultEnrolamiento.setIVREnroll(jo.getString("value"));
			jo = jArray.getJSONObject(13);
			LogResultEnrolamiento.setApxbackend(jo.getString("value"));
			jo = jArray.getJSONObject(14);
			LogResultEnrolamiento.setSSO2(jo.getString("value"));
			jo = jArray.getJSONObject(15);
			LogResultEnrolamiento.setLDAPUser(jo.getString("value"));
			jo = jArray.getJSONObject(16);
			LogResultEnrolamiento.setEnrollBiometrico(jo.getString("value"));
			jo = jArray.getJSONObject(17);
			LogResultEnrolamiento.setIsArco(jo.getString("value"));
			
			System.out.println("Json Log creado con éxito");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String args[]){
		/*createJsonInstrument1Prod("5549423627");
		JSONObject jo;
		try {
			jo = (JSONObject) new JSONTokener(IOUtils.toString(new URL("https://www.bancomermovil.com/bm3wxp_mx_web/servlet/ServletOperacionWeb?OPERACION=BAN2O05&LOCALE=es_ES&PAR_INICIO.0={\"operacion\":\"consultaEstatusMantenimiento\",\"verCatTelefonicas\":\"0\",\"verCatAutenticacion\":\"0\",\"numeroTelefono\":\"5549423627\",\"VM\":\"100\"}"))).nextValue();
			jo.remove("autenticacion");
			jo.remove("telefonicasMantenimiento");
			jo.remove("ocNotificaciones");
			System.out.println(jo.toString());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
	}
	
	//Intente commit
}
