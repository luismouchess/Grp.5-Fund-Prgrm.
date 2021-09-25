package Programas;
import java.util.Scanner;

public class TrabajoFInal {
    public static void main(String[] args) {
    int clave =123;
    int numeroProforma = 0;

    //datos
    String[] tipoServicio = {"RECOJO","ENVIO"};
    String[] codigoServicio = {"RE","EN"};
    String[] tipoCarga = {"LOCAL","NACIONAL"};
    String[] codigoCarga = {"LO","NA"};
    String[] tipoEnvio = {"PAQUETE","SOBRE"};
    String[] codigoEnvio = {"PA","SO"};
    String[] tipoUnidad = {"GRAMOS","KILOGRAMOS"};
    String[] tipoRecojo = {"CON RECOJO","SIN RECOJO"};

    String[] Codigodistrito = {"LI","CA","JE","MO","VE","VI","BR","MI","LO","CO"};
    String[] distrito = {"LIMA","CALLAO","JESUS MARIA","LA MOLINA","VENTANILLA","LA VICTORIA","BREÑA","MIRAFLORES","LOS OLIVOS","COMAS"};
    String[] Codigoprovincia = {"LI","CA","IC","CU","IQ","TU","AR","TA","PU","MO"};
    String[] provincia = {"LIMA","CALLAO","ICA","CUZCO","IQUITOS","TUMBES","AREQUIPA","TACNA","PUNO","MOQUEGUA"};
    String[] tipoEmbalaje = {"PALETA DE MADERA","CARTON CORRUGADO","SACOS DE YUTE","PLASTIFICADO"};
    String[] tarifaZona = {"ZONA1","ZONA2","ZONA3","ZONA4"};
    int [] Tarifas = {35,45,50,65,70,75,80,85,95,100};
    int [] Tiempo ={1,2,3,5};

    System.out.println("******************************************************************************");

        Scanner teclado;
        int cantidad,itemServicio,itemCarga,itemDistrito,itemDistritoRecojo,itemDistritoEnvio,itemEnvio,itemPeso,itemUnidad;
        teclado = new Scanner(System.in);

        System.out.println("===========SISTEMA DE CONSULTA DE ENVIO/RECOJOS===============================");
        System.out.println("\nSelecciona las opciones para la cotizacion  ");
        System.out.println("\nTipo Servicio:  ");
        System.out.println("1. Recojo");
        System.out.println("2. Envio");
        System.out.println("Selecciona el número de item correspondiente: ");
        itemServicio = teclado.nextInt();

        System.out.println("\nTipo Carga:  ");
        System.out.println("1. LOCAL");
        System.out.println("2. NACIONAL");
        System.out.println("Selecciona el número de item correspondiente: ");
        itemCarga = teclado.nextInt();

        if (itemCarga==1 && itemServicio ==1){
            System.out.println("Digita el Distrito de recojo/envio");
            System.out.println("[1]. LIMA");
            System.out.println("[2]. CALLAO");
            System.out.println("[3]. JESUS MARIA");
            System.out.println("[4]. LA MOLINA");
            System.out.println("[5]. VENTANILLA");
            System.out.println("[6]. LA VICTORIA");
            System.out.println("[7]. BREÑA");
            System.out.println("[8]. MIRAFLORES");
            System.out.println("[9]. LOS OLIVOS");
            System.out.println("[10]. COMAS");
            itemDistritoRecojo = teclado.nextInt();
            itemDistritoEnvio = teclado.nextInt();


           // System.out.println(generaCodigo(itemDistrito));
           }
        if (itemCarga==1 && itemServicio ==2){
            System.out.println("Digita el Distrito de recojo/envio");
            System.out.println("[1]. LIMA");
            System.out.println("[2]. CALLAO");
            System.out.println("[3]. JESUS MARIA");
            System.out.println("[4]. LA MOLINA");
            System.out.println("[5]. VENTANILLA");
            System.out.println("[6]. LA VICTORIA");
            System.out.println("[7]. BREÑA");
            System.out.println("[8]. MIRAFLORES");
            System.out.println("[9]. LOS OLIVOS");
            System.out.println("[10]. COMAS");
            itemDistritoEnvio = teclado.nextInt();
        }

        System.out.println("\nTipo de Envio:  ");
        System.out.println("1. PAQUETE");
        System.out.println("2. SOBRE");
        System.out.println("Selecciona el número de item correspondiente: ");
        itemEnvio = teclado.nextInt();
        if (itemEnvio==1 ){
            System.out.println("Digita peso del Paquete :");
            itemPeso = teclado.nextInt();
            System.out.println("Digita la medida :");
        }
       if (itemEnvio==2 ){
            System.out.println("Digita el peso del sobre en :");
            System.out.println("[1]. GRAMOS");
            System.out.println("[2]. KILOGRAMOS");
            itemUnidad = teclado.nextInt();
            System.out.println("INGRESE EL PESO DEL SOBRE (Peso maximo 1 Kg):");
            itemPeso = teclado.nextInt();
            //System.out.println(obtenerPorcentaje(itemPeso));
           //sc.nextLine();
        }
       // String tipo = generarCodigoProforma(operacion);
       // System.out.println("la operacion es  : " + operacion  + " cantidad de operaciones : " + operacion.substring(14,17) + "-" + "Tipo de Operacion : "+  tipo);
        String codigo = generaCodigo(itemServicio,itemDistritoRecojo,Codigodistrito,itemDistritoEnvio,itemEnvio,itemPeso,tipoEnvio,tipoServicio);
        System.out.println("AQUI :" + codigo);
    }
    // leyenda:
    // RE=RECOJO / EN=ENVIO
    // LO=LOCAL / NA=NACIONAL
    // LI=CODIGO DISTRITO RECOJO
    // VE=CODIGO DISTRITO ENVIO
    // PA=PAQUETE / SO=SOBRE
    //
    //RENALI
//***********************
    private static String generaCodigo(int itemServicio, int itemDistritoRecojo,String[] Codigodistrito int itemDistritoEnvio ,
                                       int itemEnvio,int itemPeso,String[] tipoEnvio, String[] tipoServicio) {
        //objetivo : generar el codigo de la proforma
        // RELI
      String servicio,distritoRecojo,xcodigo = null;

      servicio = generaServicio(itemServicio,tipoServicio);
      distritoRecojo = obtieneDistritoR(itemDistritoRecojo,Codigodistrito);
      distritoRecojo = obtieneDistritoR(itemDistritoEnvio,Codigodistrito);

      for (int i = 0; i < (tipoEnvio.length); i++) {
            if (Codigodistrito[i].equals(Codigodistrito[itemDistritoRecojo-1]))
                xcodigo= Codigodistrito[i];
        }

      String codigo = servicio+ xcodigo;
      return codigo;
   }
//**********************
    private static String generaServicio(int itemServicio , String[] tipoServicio) {
    String codigoSer = null;

        for (int i = 0; i < (tipoServicio.length); i++) {
        if (tipoServicio[i].equals(tipoServicio[itemServicio-1]))
            codigoSer= tipoServicio[i];
         }
    return codigoSer;
    }
//**********************

    private static String obtieneDistritoR(int itemDistritoRecojo,String[] Codigodistrito) {
        String codigoDis = null;

        for (int i = 0; i < (Codigodistrito.length); i++) {
            if (Codigodistrito[i].equals(Codigodistrito[itemDistritoRecojo-1]))
                codigoDis= Codigodistrito[i];
        }
        return codigoDis;
    }



}
/*ICA 12
        CHINCHA 12
        PISCO 12
        CAÑETE 12
        NAZCA 12  2 KILOS 17
        AREQUIPA 15 2 KILOS 19
        CUSCO 15
        PIURA 12   2 KILOS 17
        TUMBES  12
        TACNA  15 */