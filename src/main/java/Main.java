import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        try {
            ReadFile fileRes = new ReadFile("data/GettysburgAddress.txt");


            String[] paragraphs = fileRes.getParagraphs();

            ArrayList<Paragraph> paragraphList = new ArrayList<>();

            for (String paragraph : paragraphs) {
                Paragraph p = new Paragraph(paragraph);
                paragraphList.add(p);
            }

            int paragraphNum = 1;
            for (Paragraph p : paragraphList) {
                System.out.println("Paragraph " + paragraphNum + "\n" + p.getWords() + "\n");
                paragraphNum++;
            }

        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        }
    }
}