package clienteescritoriocupones.modelo.dao;

import clienteescritoriocupones.modelo.ConexionWS;
import clienteescritoriocupones.modelo.pojo.Mensaje;
import clienteescritoriocupones.modelo.pojo.Promocion;
import clienteescritoriocupones.modelo.pojo.PromocionSucursal;
import clienteescritoriocupones.modelo.pojo.RespuestaHTTP;
import clienteescritoriocupones.utils.Constantes;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;


public class PromocionDAO {
    
    //-------------------------------- Lista de Promociones --------------------------------\\
    public static HashMap<String, Object> listaPromociones(){
        HashMap<String, Object> respService = new LinkedHashMap<>();
        List<Promocion> promocion =null;
        String url = Constantes.URL_WS+"promocion/promociones";
        RespuestaHTTP respuesta = ConexionWS.peticionGET(url);
        System.out.println(url);
        if(respuesta.getCodigoRespuesta() == HttpURLConnection.HTTP_OK){
           Gson gson = new Gson();
           Type tipoListaPromocion = new TypeToken<List<Promocion>>(){}.getType();
           promocion = gson.fromJson(respuesta.getContenido(), tipoListaPromocion);
           respService.put("error", false);
           respService.put("promocion", promocion);
        }else{
            respService.put("error", true);
            respService.put("mensaje","Hubo un error en la peticion, por el momento no se puede cargar "
                    + "la informacion de las promociones");
        }
        return respService;
    }
    
    //-------------------------------- Agregar Promoción --------------------------------\\
    public static Mensaje agregarPromocion(Promocion promocion){
        Mensaje msj = new Mensaje();
        String url = Constantes.URL_WS+"prmocion/agregarPromocion";
        Gson gson = new Gson();
        String parametros = gson.toJson(promocion);
        RespuestaHTTP respuestaPeticion = ConexionWS.peticionPOSTJSON(url, parametros);
        if(respuestaPeticion.getCodigoRespuesta()== HttpURLConnection.HTTP_OK){
            msj = gson.fromJson(respuestaPeticion.getContenido(), Mensaje.class);
        }else{
            msj.setError(true);
            msj.setMensaje("Hubo un error al procesar la solictud, porfavor intentalo más tarde");
        }        
        return msj;
    }
    
    //-------------------------------- Modificar Promoción --------------------------------\\
    public static Mensaje modificarPromocion(Promocion promocion){
        Mensaje msj = new Mensaje();
        String url = Constantes.URL_WS+"prmocion/editarPromocion";
        Gson gson = new Gson();
        String parametros = gson.toJson(promocion);
        RespuestaHTTP respuestaPeticion = ConexionWS.peticionPUTJSON(url, parametros);
        if(respuestaPeticion.getCodigoRespuesta()== HttpURLConnection.HTTP_OK){
            msj = gson.fromJson(respuestaPeticion.getContenido(), Mensaje.class);
        }else{
            msj.setError(true);
            msj.setMensaje("Hubo un error al procesar la solictud, porfavor intentalo más tarde");
        }        
        return msj;
    }
    
    //-------------------------------- Eliminar Promoción --------------------------------\\
    public static Mensaje eliminarPromocion(int idPromocion){
        Mensaje msj = new Mensaje();
        String url = Constantes.URL_WS+"prmocion/eliminarPromocion";
        Gson gson = new Gson();
        String parametros = gson.toJson(idPromocion);
        RespuestaHTTP respuestaPeticion = ConexionWS.peticionDELETEJSON(url, parametros);
        if(respuestaPeticion.getCodigoRespuesta()== HttpURLConnection.HTTP_OK){
            msj = gson.fromJson(respuestaPeticion.getContenido(), Mensaje.class);
        }else{
            msj.setError(true);
            msj.setMensaje("Hubo un error al procesar la solictud, porfavor intentalo más tarde");
        }        
        return msj;
    }
    
    //-------------------------------- Buscar Promoción por Nombre--------------------------------\\
    public static HashMap<String, Object> buscarPromocionPorNombre(String nombre){
        HashMap<String, Object> respService = new LinkedHashMap<>();
        String url = Constantes.URL_WS+"promocion/promocionNombre/"+nombre;
        RespuestaHTTP respuesta = ConexionWS.peticionGET(url);
        System.out.println(url);
        if(respuesta.getCodigoRespuesta() == HttpURLConnection.HTTP_OK){
            respService.put("error", false);
            respService.put("promocion", respuesta.getContenido());
        
        }else{
            respService.put("error", true);
            respService.put("mensaje","Hubo un error en la peticion, por el momento no se puede cargar "
                    + "la informacion de las promociones");
        }
        return respService;
        
    }
    
    
    //-------------------------------- Detalle de promoción por id --------------------------------\\
    public static HashMap<String, Object> detallePromocion(int idPromocion){
        HashMap<String, Object> respService = new LinkedHashMap<>();
        String url = Constantes.URL_WS+"promocion/detallesPromocion/"+idPromocion;
        RespuestaHTTP respuesta = ConexionWS.peticionGET(url);
        System.out.println(url);
        if(respuesta.getCodigoRespuesta() == HttpURLConnection.HTTP_OK){
            respService.put("error", false);
            respService.put("promocion", respuesta.getContenido());
        
        }else{
            respService.put("error", true);
            respService.put("mensaje","Hubo un error en la peticion, por el momento no se puede cargar "
                    + "la informacion de las promociones");
        }
        return respService;
        
    }
    
    //-------------------------------- Lista de promociones por Categoría --------------------------------\\
    public static HashMap<String, Object> listaPromocionesPorCategoria(int idCategoria){
        HashMap<String, Object> respService = new LinkedHashMap<>();
        List<Promocion> promociones = null;
        String url = Constantes.URL_WS+"promocion/promocionCategoria/"+ idCategoria;
        RespuestaHTTP respuesta = ConexionWS.peticionGET(url);
        System.out.println(url);
        if(respuesta.getCodigoRespuesta() == HttpURLConnection.HTTP_OK){
            Gson gson = new Gson();
            Type tipoListaPromocion = new TypeToken<List<Promocion>>(){}.getType();
            promociones = gson.fromJson(respuesta.getContenido(), tipoListaPromocion);
            respService.put("error", false);
            respService.put("promocion", promociones);
        
        }else{
            respService.put("error", true);
            respService.put("mensaje","Hubo un error en la peticion, por el momento no se puede cargar "
                    + "la informacion de las promos");
        }
        return respService;
         
    }
    //-------------------------------- Lista de promociones por decha de inicio --------------------------------\\
    public static HashMap<String, Object> listaPromocionesPorCategoria(String fechaInicio){
        HashMap<String, Object> respService = new LinkedHashMap<>();
        List<Promocion> promociones = null;
        String url = Constantes.URL_WS+"promocion/promocionFechaInicio/"+ fechaInicio;
        RespuestaHTTP respuesta = ConexionWS.peticionGET(url);
        System.out.println(url);
        if(respuesta.getCodigoRespuesta() == HttpURLConnection.HTTP_OK){
            Gson gson = new Gson();
            Type tipoListaPromocion = new TypeToken<List<Promocion>>(){}.getType();
            promociones = gson.fromJson(respuesta.getContenido(), tipoListaPromocion);
            respService.put("error", false);
            respService.put("promocion", promociones);
        
        }else{
            respService.put("error", true);
            respService.put("mensaje","Hubo un error en la peticion, por el momento no se puede cargar "
                    + "la informacion de las promos");
        }
        return respService;
         
    }
    //-------------------------------- Buscar promoción por ID --------------------------------\\
    public static HashMap<String, Object> obtenerPromocionPorId(int idPromocion){
        HashMap<String, Object> respService = new LinkedHashMap<>();
        String url = Constantes.URL_WS+"promocion/promocionPorId/"+idPromocion;
        RespuestaHTTP respuesta = ConexionWS.peticionGET(url);
        System.out.println(url);
        if(respuesta.getCodigoRespuesta() == HttpURLConnection.HTTP_OK){
            respService.put("error", false);
            respService.put("promocion", respuesta.getContenido());
        
        }else{
            respService.put("error", true);
            respService.put("mensaje","Hubo un error en la peticion, por el momento no se puede cargar "
                    + "la informacion de las promociones");
        }
        return respService;
        
    }
    
    //-------------------------------- Lista de promociones por Sucursal --------------------------------\\
    public static HashMap<String, Object> listaPromocionesPorSucursal(PromocionSucursal promocion){
        HashMap<String, Object> respService = new LinkedHashMap<>();
        List<Promocion> promociones = null;
        String url = Constantes.URL_WS+"promocion/promocionPorSucursal";
        
        Gson gson = new Gson();
        String parametros = gson.toJson(promocion);
        RespuestaHTTP respuesta = ConexionWS.peticionDELETEJSON(url, parametros);
        
        if(respuesta.getCodigoRespuesta() == HttpURLConnection.HTTP_OK){
            Type tipoListaPromocion = new TypeToken<List<Promocion>>(){}.getType();
            promociones = gson.fromJson(respuesta.getContenido(), tipoListaPromocion);
            respService.put("error", false);
            respService.put("promocion", promociones);
        
        }else{
            respService.put("error", true);
            respService.put("mensaje","Hubo un error en la peticion, por el momento no se puede cargar "
                    + "la informacion de las promos");
        }
        return respService;
         
    }
}
