package configurationData;

import configurationData.XlsData;

public class XlsData {
		//Tiempo y error
		private static long tiempoInicio = 0;
		private static String error="";
		
		//Datos obligatorios
		private static String NombreTestCase = "";
		private static String Descripcion = "";
		private static String SistemaOperativo = "";
		private static String Version = "";
		private static String NombreDispositivo = "";
		private static String ModeloDispositivo = "";
		private static String Ambiente = "";
		
		//Datos variables
		private static String NumeroCelular = "";
		private static String NumeroTarjeta = "";
		private static String CVV = "";
		private static String NIP = "";
		
		private static String ContraseniaActual ="";
		private static String ContraseniaNueva ="";
		
		private static String CorreoElectronicoActual ="";
		private static String CorreoElectronicoNuevo ="";
		
		private static String CuentaOrigen = "";
		private static String CuentaBeneficiario = "";
		private static String Importe = "";
		private static String Concepto = "";
		
		private static String MontoMaxOperacion = "";
		private static String MontoMaxDiario = "";
		private static String MontoMaxMes = "";
		
		private static String AlertaDeposito = "";
		private static String AlertaCargo = "";
		
		private static String Beneficiario = "";
		
		private static String NombreFrecuente = "";
		private static String CorreoFrecuente = "";
		
		public static String getCorreoFrecuente() {
			return CorreoFrecuente;
		}
		public static void setCorreoFrecuente(String correoFrecuente) {
			CorreoFrecuente = correoFrecuente;
		}
		public static String getNombreFrecuente() {
			return NombreFrecuente;
		}
		public static void setNombreFrecuente(String nombreFrecuente) {
			NombreFrecuente = nombreFrecuente;
		}
		public static String getBeneficiario() {
			return Beneficiario;
		}
		public static void setBeneficiario(String beneficiario) {
			Beneficiario = beneficiario;
		}
		public static long getTiempoInicio() {
			return tiempoInicio;
		}
		public static void setTiempoInicio(long tiempoInicio) {
			XlsData.tiempoInicio = tiempoInicio;
		}
		public static String getNombreTestCase() {
			return NombreTestCase;
		}
		public static void setNombreTestCase(String nombreTestCase) {
			NombreTestCase = nombreTestCase;
		}
		
		public static String getTestCaseDivided(){
			String[] testcaseDivided=XlsData.NombreTestCase.split("-");
			return testcaseDivided[2];
		}
		public static void iniciarTiempo()
		{
			XlsData.tiempoInicio=System.currentTimeMillis();
		}
		public static long gettiempoInicio()
		{
			return XlsData.tiempoInicio;
		}
		public static void setError(String error)
		{
			XlsData.error=XlsData.error+error;
		}
		public static String getError()
		{
			return XlsData.error;
		}
		
		public static void setNombreCaso(String NombreCaso)
		{
			XlsData.NombreTestCase=NombreCaso;
		}
		public static String getNombreCaso()
		{
			return NombreTestCase;
		}
		
		public static void setDescripcion(String Descripcion)
		{
			XlsData.Descripcion=Descripcion;
		}
		public static String getDescripcion()
		{
			return Descripcion;
		}
		
		
		public static void setSistemaOperativo(String SistemaOperativo)
		{
			XlsData.SistemaOperativo=SistemaOperativo;
		}
		public static String getSistemaOperativo()
		{
			return SistemaOperativo;
		}
		
		public static void setVersion(String version)
		{
			XlsData.Version=version;
		}
		public static String getVersion()
		{
			return Version;
		}
		
		public static void setNombreDispositivo(String nombreDispositivo)
		{
			XlsData.NombreDispositivo=nombreDispositivo;
		}
		public static String getNombreDispositivo()
		{
			return NombreDispositivo;
		}
		
		public static void setModeloDispositivo(String nombreDispositivo)
		{
			XlsData.ModeloDispositivo=nombreDispositivo;
		}
		public static String getModeloDispositivo()
		{
			return ModeloDispositivo;
		}
		
		public static String getAmbiente() {
			return Ambiente;
		}
		public static void setAmbiente(String ambiente) {
			Ambiente = ambiente;
		}
		
		
		public static String getNumeroCelular() {
			return NumeroCelular;
		}
		public static void setNumeroCelular(String numeroCelular) {
			NumeroCelular = numeroCelular;
		}
		public static String getNumeroTarjeta() {
			return NumeroTarjeta;
		}
		public static void setNumeroTarjeta(String numeroTarjeta) {
			NumeroTarjeta = numeroTarjeta;
		}
		public static String getCVV() {
			return CVV;
		}
		public static void setCVV(String cVV) {
			CVV = cVV;
		}
		public static String getNIP() {
			return NIP;
		}
		public static void setNIP(String nIP) {
			NIP = nIP;
		}
		
		
		public static String getContraseniaActual() {
			return ContraseniaActual;
		}
		public static void setContraseniaActual(String contraseniaActual) {
			ContraseniaActual = contraseniaActual;
		}
		public static String getContraseniaNueva() {
			return ContraseniaNueva;
		}
		public static void setContraseniaNueva(String contraseniaNueva) {
			ContraseniaNueva = contraseniaNueva;
		}
		public static String getCorreoElectronicoActual() {
			return CorreoElectronicoActual;
		}
		public static void setCorreoElectronicoActual(String correoElectronicoActual) {
			CorreoElectronicoActual = correoElectronicoActual;
		}
		public static String getCorreoElectronicoNuevo() {
			return CorreoElectronicoNuevo;
		}
		public static void setCorreoElectronicoNuevo(String correoElectronicoNuevo) {
			CorreoElectronicoNuevo = correoElectronicoNuevo;
		}
		
		
		public static String getCuentaOrigen() {
			return CuentaOrigen;
		}
		public static void setCuentaOrigen(String cuentaOrigen) {
			CuentaOrigen = cuentaOrigen;
		}
		public static String getCuentaBeneficiario() {
			return CuentaBeneficiario;
		}
		public static void setCuentaBeneficiario(String cuentaBeneficiario) {
			CuentaBeneficiario = cuentaBeneficiario;
		}
		public static String getImporte() {
			return Importe;
		}
		public static void setImporte(String importe) {
			Importe = importe;
		}
		public static String getConcepto() {
			return Concepto;
		}
		public static void setConcepto(String concepto) {
			Concepto = concepto;
		}
		
		public static String getMontoMaxOperacion() {
			return MontoMaxOperacion;
		}
		public static void setMontoMaxOperacion(String montoMaxOperacion) {
			MontoMaxOperacion = montoMaxOperacion;
		}
		public static String getMontoMaxDiario() {
			return MontoMaxDiario;
		}
		public static void setMontoMaxDiario(String montoMaxDiario) {
			MontoMaxDiario = montoMaxDiario;
		}
		public static String getMontoMaxMes() {
			return MontoMaxMes;
		}
		public static void setMontoMaxMes(String montoMaxMes) {
			MontoMaxMes = montoMaxMes;
		}
		public static String getAlertaDeposito() {
			return AlertaDeposito;
		}
		public static void setAlertaDeposito(String alertaDeposito) {
			AlertaDeposito = alertaDeposito;
		}
		public static String getAlertaCargo() {
			return AlertaCargo;
		}
		public static void setAlertaCargo(String alertaCargo) {
			AlertaCargo = alertaCargo;
		}
}
