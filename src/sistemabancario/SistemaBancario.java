package sistemabancario;

import javax.swing.JOptionPane;

public class SistemaBancario {

    public static void main(String[] args) {
        PlazoFijo Calculadora = new PlazoFijo();
        Calculadora.setTitle("Nombre de pantalla");  //Cambio el nombre de la ventana
        Calculadora.setLocationRelativeTo(null);     //Centro la pantalla
        Calculadora.setVisible(false);
        int opt = 1, des, num_in, saldoAct = 1000;
        
        do{
            do{
                opt = Integer.parseInt(JOptionPane.showInputDialog("Bienvenido al sistema bancario\n"
                      + "Su saldo actual es de $" + saldoAct + ". ¿Qué acción desea efectuar?\n"
                      + "1. Ingresar dinero\n2. Extraer dinero\n"
                      + "3. Calcular plazo fijo (TNA del 30,02%)\n4. Salir"));
                if (opt >= 5 || opt <= 0){
                    JOptionPane.showMessageDialog(null, "El numero debe estar en los rango establecidos",
                            "Error de seleccion", JOptionPane.ERROR_MESSAGE);
                }
            }while(opt >= 5 || opt <= 0);

            switch (opt){
                case 1:
                    num_in = Integer.parseInt(JOptionPane.showInputDialog("Ingrese saldo a ingresar"));
                    saldoAct = saldoAct + num_in;
                    JOptionPane.showMessageDialog(null, "Tu saldo actual es de $" + saldoAct);
                    break;
                case 2:
                    do{
                        num_in = Integer.parseInt(JOptionPane.showInputDialog("Ingrese saldo a extraer"));
                        if (saldoAct-num_in < 0){
                        JOptionPane.showMessageDialog(null, "No es posible procesar el pedido.\nIngrese nuevamente.",
                                "Error de ingreso", JOptionPane.ERROR_MESSAGE);
                        }
                    }while(saldoAct-num_in < 0);
                    saldoAct = saldoAct - num_in;
                    JOptionPane.showMessageDialog(null, "Tu saldo actual es de $" + saldoAct);
                    break;

                case 3:
                        Calculadora.setVisible(true);
                    break;
                case 4:
                    break;
            }
            des = JOptionPane.showConfirmDialog(null, "¿Desea efectuar otra operación?",
                    "¿Continuar?", JOptionPane.YES_NO_OPTION);  //des=0 para si, des=1 para no
        }while(des == JOptionPane.YES_OPTION);
    }
}
