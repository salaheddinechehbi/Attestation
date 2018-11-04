
import classes.Employe;
import classes.Region;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import service.EmployeService;
import service.RegionService;
import util.HibernateUtil;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author salah
 */
public class MainTest {
    
    public static void main(String[] args) throws FileNotFoundException, IOException{
        
       //HibernateUtil.getSessionFactory().openSession();
       
       File excelfile = new File("ARCHIVES.xlsx");
       FileInputStream ipt = new FileInputStream(excelfile);
       XSSFWorkbook work = new XSSFWorkbook(ipt);
       XSSFSheet sheet = work.getSheet("données");
       Iterator<Row> itr = sheet.iterator();
       while(itr.hasNext()){
            Row row = itr.next();
            Iterator<Cell> itcell = row.cellIterator();
            while(itcell.hasNext()){
                Cell cell = itcell.next();
                System.out.print(cell.toString()+";");
            }
            System.out.println("");
        }
       work.close();
       ipt.close();
        
//       EmployeService es = new EmployeService();
//            Employe e = es.findById(2);
//            e.setNom("SafiSafi");
//            es.update(e);
//            System.out.println(""+es.findById(2).getNom());
//       RegionService rs = new RegionService();
//       rs.create(new Region("Région de Tanger-Tétouan-Al Hoceïma"));
//       rs.create(new Region("Région de l'Oriental"));
//       rs.create(new Region("Région de Fès-Meknès"));
//       rs.create(new Region("Région de Rabat-Salé-Kénitra"));
//       rs.create(new Region("Région de Béni Mellal-Khénifra"));
//       rs.create(new Region("Région de Casablanca-Settat"));
//       rs.create(new Region("Région de Marrakech-Safi"));
//       rs.create(new Region("Région de Drâa-Tafilalet"));
//       rs.create(new Region("Région de Souss-Massa"));
//       rs.create(new Region("Région de Guelmim-Oued Noun"));
//       rs.create(new Region("Région de Laâyoune-Sakia El Hamra"));
//       rs.create(new Region("Région de Dakhla-Oued Ed Dahab"));
    }
}
