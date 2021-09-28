package Programas;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TrabajoFInal {
    public static void main(String[] args) {
        List<String> datosProforma = new ArrayList<String>();

        String[] codigoBoletas = {"LO1250","LO1251","NA1350","NA1351"};
        int itemPeso=0;

        int cantidad,itemServicio,itemCarga,itemDistrito,itemDistritoRecojo,itemEnvio,itemUnidad,itemTamaño,itemForma;
        int itemProvinciaRecojo,itemProvinciaEnvio,itemDistritoDestino;
        int itemEmbala=0;
        String itemDirRecojo;
     //datos

        String[] tipoCarga = {"LOCAL","NACIONAL"};
        String[] codigoCarga = {"LO","NA"};
        String[] tipoEnvio = {"PAQUETE","SOBRE"};
        String[] codigoEnvio = {"PA","SO"};
        String[] tipoUnidad = {"GRAMOS","KILOGRAMOS"};
        String[] tipoRecojo = {"CON RECOJO","SIN RECOJO"};
        String[] tipoEmbalajes = {"PALETA DE MADERA","CARTON CORRUGADO","SACOS DE YUTE","PLASTIFICADO","NINGUNO"};
        int [] costoTipoEmbalajes = {45,40,20,15,0};

        String[] Codigodistrito = {"LI","CA","JE","MO","VE","VI","BR","MI","LO","CO"};
        String[] distrito = {"LIMA","CALLAO","JESUS MARIA","LA MOLINA","VENTANILLA","LA VICTORIA","BREÑA","MIRAFLORES","LOS OLIVOS","COMAS"};
        String[] provincia = {"LIMA","CALLAO","ICA","CUZCO","IQUITOS","TUMBES","AREQUIPA","TACNA","PUNO","MOQUEGUA"};

        String[] ZONA1 = {"LIMA","CALLAO","JESUS MARIA","LA VICTORIA","BREÑA","LOS OLIVOS"};
        String[] ZONA2 = {"LA MOLINA","VENTANILLA","MIRAFLORES","LA MOLINA","COMAS"};

    System.out.println("******************************************************************************");
      Scanner teclado,teclado2;
        teclado = new Scanner(System.in);
        teclado2 = new Scanner(System.in);

        System.out.println("===========SISTEMA DE CONSULTA DE ENVIO/RECOJOS===============================");
        System.out.println("\nSelecciona las opciones para la cotizacion del Servicio Recojo/Envio ");
        System.out.println("\nTipo Carga:  ");
        System.out.println("1. LOCAL");
        System.out.println("2. NACIONAL");
        itemCarga = teclado.nextInt();

        System.out.println("DIRECCION DE RECOJO :");
        String itemDireccion = teclado2.nextLine();

        System.out.println("Digite el Distrito de recojo");
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

        if (itemCarga == 1){
            System.out.println("Digite el Distrito de destino");
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
            itemDistritoDestino = teclado.nextInt();
        }

        if (itemCarga==2){
            System.out.println("Digite el Provincia de destino");
            System.out.println("[1]. LIMA");
            System.out.println("[2]. CALLAO");
            System.out.println("[3]. ICA");
            System.out.println("[4]. CUZCO");
            System.out.println("[5]. IQUITOS");
            System.out.println("[6]. TUMBES");
            System.out.println("[7]. AREQUIPA");
            System.out.println("[8]. TACNA");
            System.out.println("[9]. PUNO");
            System.out.println("[10]. MOQUEGUA");
            itemProvinciaEnvio = teclado.nextInt();
        }
             System.out.println("\nTipo de Envio:  ");
            System.out.println("[1]. PAQUETE");
            System.out.println("[2]. SOBRE");
            itemEnvio = teclado.nextInt();

            if (itemEnvio==1 ){ //paquete

            System.out.println("Requiere Embalaje ? ");
            System.out.println("[1]. PALETA DE MADERA - (S/45)");
            System.out.println("[2]. CARTON CORRUGADO - (S/40)");
            System.out.println("[3]. SACOS DE YUTE - (S/20)");
            System.out.println("[4]. PLASTIFICADO - (S/15)");
            System.out.println("[5]. NINGUNO");
            itemEmbala = teclado.nextInt();


            System.out.println("Digita peso del Paquete :");
            itemPeso = teclado.nextInt();

        }

       if (itemEnvio==2 ){
            System.out.println("Digita el peso del sobre en :");
            System.out.println("[1]. GRAMOS");
            System.out.println("[2]. KILOGRAMOS");
            itemUnidad = teclado.nextInt();

            System.out.println("Peso del sobre :");
            itemPeso = teclado.nextInt();
        }
            System.out.println("Tipo Servicio :");
            System.out.println("[1]. REGULAR");
            System.out.println("[2]. EXPRES");
            itemForma = teclado.nextInt();


        double montoP = ObtieneMontoPqte(itemPeso,itemEnvio,itemCarga ,itemDistritoRecojo ,distrito ,ZONA1,ZONA2 );
        String distritoP = obtieneDistritoR(itemDistritoRecojo,Codigodistrito);
        int montoEm = obtieneCostoEmbalaje(tipoEmbalajes,costoTipoEmbalajes,itemEmbala);
        String carga = tipoCarga[itemCarga-1];


        double total=0,subtotal=0;
        subtotal=montoP+montoEm;
        total = total+subtotal;


        System.out.println("-".repeat(85));
        System.out.println("                     SHARFF - PROFORMA DE COSTO DE ENVIOS/RECOJOS" );
        System.out.println("Tipo Carga : " + carga);
        System.out.println("Dirección  : " + itemDireccion + "-"+ distritoP);
        System.out.println("-".repeat(85));
        System.out.println("-".repeat(85));
        System.out.println(carga + "       ");
        System.out.print("       ");
        System.out.println();
        System.out.println("-".repeat(85));
        System.out.printf("|%83s|\n", "Total: " + String.valueOf(total));
    }

    private static String TraerCarga(int itemCarga, String[] tipoCarga) {
        String cargaE = null;

        for (int i = 0; i < (tipoCarga.length); i++) {
             if ((Integer.parseInt(tipoCarga[i])) == (Integer.parseInt(tipoCarga[itemCarga-1]))) {
                cargaE= tipoCarga[i];
            }
        }
        return cargaE;
    }


    //************************
    private static int obtieneCostoEmbalaje(String[] tipoEmbalajes,int[] costoTipoEmbalajes,int itemEmbala) {
        //String[] tipoEmbalajes = {"PALETA DE MADERA","CARTON CORRUGADO","SACOS DE YUTE","PLASTIFICADO","NINGUNO"};
        //int [] costoTipoEmbalajes = {45,40,20,15,0};
        int costoE = 0;

        for (int i = 0; i < (tipoEmbalajes.length); i++) {
           if (tipoEmbalajes[i].equals(tipoEmbalajes[itemEmbala-1])) {
                costoE= costoTipoEmbalajes[i];
            }
        }
        return costoE;
    }

//**********************
private static double ObtieneMontoPqte(int itemPeso, int itemEnvio, int itemCarga , int itemDistritoRecojo , String[] distrito , String[] ZONA1, String[] ZONA2 ) {
//    String[] ZONA1 = {"LIMA","CALLAO","JESUS MARIA","LA VICTORIA","BREÑA","LOS OLIVOS"};
//    String[] ZONA2 = {"LA MOLINA","VENTANILLA","MIRAFLORES","LA MOLINA","COMAS"};

    double montoPqte=0;
    boolean existe=false;
    String xDistrito = obtieneDistritoR(itemDistritoRecojo,distrito);


           for(int i=0; i<ZONA1.length; i++){
             if (ZONA1[i].equals(xDistrito)) { //costo local , zona 1 => peso*30%
                 montoPqte = (itemPeso*0.40)/100;
                 existe=true;
                 break;
                }
             }
           if (existe==false){
               for(int i=0; i<ZONA2.length; i++){
                   if (ZONA2[i].equals(xDistrito)) { //costo local , zona 1 => peso*30%
                       montoPqte = (itemPeso*0.70)/100;
                       break;
                   }
               }

           }
          return montoPqte;
    }

//*********************
    private static String obtieneDistritoR(int itemDistritoRecojo,String[] Codigodistrito) {
        String codigoDis = null;

        for (int i = 0; i < (Codigodistrito.length); i++) {
            if (Codigodistrito[i].equals(Codigodistrito[itemDistritoRecojo-1]))
                codigoDis= Codigodistrito[i];
        }
        return codigoDis;
    }
 //**********************
    private static String obtieneProvincia(int itemProvincia,String[] provincia) {
        String codigoDis = null;

        for (int i = 0; i < (provincia.length); i++) {
            if (provincia[i].equals(provincia[itemProvincia-1]))
                codigoDis= provincia[i];
        }
        return codigoDis;
    }
 //**********************

}

