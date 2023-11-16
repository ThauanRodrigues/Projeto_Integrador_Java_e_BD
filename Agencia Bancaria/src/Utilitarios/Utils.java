package Utilitarios;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Utils {
  // Mêtodo para formatar o n° dos valores
  static NumberFormat formatandoValores = new DecimalFormat("R$ #,##0.00");
  // Transformando os valores de double para String
  public static String doubleToString(Double valor){
    return formatandoValores.format(valor);
  }
  
}
