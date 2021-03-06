package JSONLogs;

public class LogResultInstrument1 {
	  
	private static String estado = null;
	private static String numeroCliente = null;
	private static String estatusServicio = null;
	private static String companiaCelular = null;
	private static String fechaContratacion = null;
	private static String fechaSistema = null;
	private static String perfilCliente = null;
	private static String tipoInstrumento = null;
	private static String estatusInstrumento = null;
	private static String emailCliente = null;
	private static String nombreCliente = null;
	private static String estatusAlertas = null;
	private static String switchEnrolamiento = null;
	private static String autenticacion = null;
	private static String CadenaJson = null;  
	private static String ResultadoEvidencia = "";
	  
	public static String getResultadoEvidencia() {
		ResultadoEvidencia = "Estatus del servicio: "+estatusServicio+"\n"
							+"Perfil del Cliente: "+perfilCliente+"\n"
							+"Tipo de Instrumento: "+tipoInstrumento+"\n"
							+"Estatus de Instrumento: "+estatusInstrumento;
		return ResultadoEvidencia;
	}
	public static String getEstado() {
		return estado;
	}
	public static void setEstado(String estado) {
		LogResultInstrument1.estado = estado;
	}
	public static String getNumeroCliente() {
		return numeroCliente;
	}
	public static void setNumeroCliente(String numeroCliente) {
		LogResultInstrument1.numeroCliente = numeroCliente;
	}
	public static String getEstatusServicio() {
		return estatusServicio;
	}
	public static void setEstatusServicio(String estatusServicio) {
		LogResultInstrument1.estatusServicio = estatusServicio;
	}
	public static String getCompaniaCelular() {
		return companiaCelular;
	}
	public static void setCompaniaCelular(String companiaCelular) {
		LogResultInstrument1.companiaCelular = companiaCelular;
	}
	public static String getFechaContratacion() {
		return fechaContratacion;
	}
	public static void setFechaContratacion(String fechaContratacion) {
		LogResultInstrument1.fechaContratacion = fechaContratacion;
	}
	public static String getFechaSistema() {
		return fechaSistema;
	}
	public static void setFechaSistema(String fechaSistema) {
		LogResultInstrument1.fechaSistema = fechaSistema;
	}
	public static String getPerfilCliente() {
		return perfilCliente;
	}
	public static void setPerfilCliente(String perfilCliente) {
		LogResultInstrument1.perfilCliente = perfilCliente;
	}
	public static String getTipoInstrumento() {
		return tipoInstrumento;
	}
	public static void setTipoInstrumento(String tipoInstrumento) {
		LogResultInstrument1.tipoInstrumento = tipoInstrumento;
	}
	public static String getEstatusInstrumento() {
		return estatusInstrumento;
	}
	public static void setEstatusInstrumento(String estatusInstrumento) {
		LogResultInstrument1.estatusInstrumento = estatusInstrumento;
	}
	public static String getEmailCliente() {
		return emailCliente;
	}
	public static void setEmailCliente(String emailCliente) {
		LogResultInstrument1.emailCliente = emailCliente;
	}
	public static String getNombreCliente() {
		return nombreCliente;
	}
	public static void setNombreCliente(String nombreCliente) {
		LogResultInstrument1.nombreCliente = nombreCliente;
	}
	public static String getEstatusAlertas() {
		return estatusAlertas;
	}
	public static void setEstatusAlertas(String estatusAlertas) {
		LogResultInstrument1.estatusAlertas = estatusAlertas;
	}
	public static String getSwitchEnrolamiento() {
		return switchEnrolamiento;
	}
	public static void setSwitchEnrolamiento(String switchEnrolamiento) {
		LogResultInstrument1.switchEnrolamiento = switchEnrolamiento;
	}
	public static String getAutenticacion() {
		return autenticacion;
	}
	public static void setAutenticacion(String autenticacion) {
		LogResultInstrument1.autenticacion = autenticacion;
	}
	public static String getCadenaJson() {
		return CadenaJson;
	}
	public static void setCadenaJson(String cadenaJson) {
		CadenaJson = cadenaJson;
	}

}
