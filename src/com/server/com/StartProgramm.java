/*
 * package com;
 * 
 * import com.sdo.SDOServiceWell; import com.services.EquipmentService; import
 * com.utility.NewDatabase; import com.utility.NewFile; import
 * com.utility.XMLXStream;
 * 
 * import java.util.Scanner;
 * 
 * public class StartProgramm {
 * 
 * private static final String CON_STR = "jdbc:sqlite:test.db";
 * 
 * private final static EquipmentService equipmentService =
 * EquipmentService.getInstance(CON_STR); private final static SDOServiceWell
 * serviceWell= com.sdo.SDOServiceWell.getInstance(CON_STR);
 * 
 * public static void main(String[] args) {
 * 
 * NewFile.createFile("test.db");
 * 
 * NewDatabase.createDatabase(CON_STR);
 * 
 * SDOServiceWell.getInstance("1"); System.out.println("Выберите функцию:");
 * System.out.println("1-Создание N кол-ва оборудования на скважине.");
 * System.out.println("2-Вывод общей информации об оборудовании на скважинах.");
 * System.out.println("3-Экспорт всех данных в xml файл."); //
 * System.out.println("4-Изменить имя скважины(sdo)");
 * System.out.println("5-Вывести все названия скважин(sdo)");
 * 
 * Scanner sc = new Scanner(System.in); int choose = sc.nextInt(); switch
 * (choose) { //В процессе case 1: createNEquipment(sc); break; //Сделано case
 * 2: outputAllInformationAboutWell(sc); break; case 3: exportXMLFile(sc);
 * break; case 4: updateWell(sc); break; case 5: getAllWell(); break; }
 * 
 * sc.close(); } //Создание оборудования на скважинах private static void
 * createNEquipment(Scanner sc) {
 * 
 * System.out.println("Введите имя скважины"); String wellName = sc.next();
 * System.out.println("Введите количество оборудования"); int countEquipment =
 * sc.nextInt(); equipmentService.createEquipment(wellName, countEquipment); }
 * 
 * //Информация об оборудовании на скважинах private static void
 * outputAllInformationAboutWell(Scanner sc) {
 * 
 * System.out.println("Введите имена скважин через \",\""); String strName =
 * sc.next();
 * 
 * String[] arrName = strName.split(","); for (String wellName : arrName) {
 * if(wellName!=null || !wellName.equals(""))
 * equipmentService.countEquipment(wellName); else
 * System.out.println("Имя скважины не может быть пустым"); }
 * 
 * } //Вывод в xml private static void exportXMLFile(Scanner sc) {
 * 
 * System.out.println("Введите имя файла для экспорта в XML"); String
 * pathName=sc.next(); pathName+=".xml"; XMLXStream.outputXML(pathName,CON_STR);
 * } private static void updateWell(Scanner sc){
 * System.out.println("Введите имя изменяемой скважины"); String oldName
 * =sc.next(); System.out.println(" Введите новое имя"); String newName
 * =sc.next(); serviceWell.renameObject(oldName,newName); } private static void
 * getAllWell(){ serviceWell.getAll(); } }
 */