import javax.swing.JOptionPane;

public class Equation {
    public static void main(String[] args) {
        String choice;
        choice = JOptionPane.showInputDialog(null,
        "Which form is the equation(s)?" +
        "\n1. First-degree with one variable" +
        "\n2. System of first-degree with two variables" +
        "\n3. Second-degree with one variable", "Menu", JOptionPane.INFORMATION_MESSAGE);
        
        String strA, strB, strC, strD, strE, strF;
        double a, b, c, d, e, f;

        switch(choice) {
            case "1":
                strA = JOptionPane.showInputDialog(null,
                    "The equation should have the form of ax + b = 0" + "\nEnter a:", "First-degree with one variable", JOptionPane.INFORMATION_MESSAGE);
                a = Double.parseDouble(strA);

                strB = JOptionPane.showInputDialog(null,
                        "The equation should have the form of ax + b = 0" + "\nEnter b:", "First-degree with one variable", JOptionPane.INFORMATION_MESSAGE);
                b = Double.parseDouble(strB);

                JOptionPane.showMessageDialog(null, (a) + "x + " + (b) + " = 0" +
                        "\n=> x = " + (b != 0?(b/a):"undefined"),
                        "Result", JOptionPane.INFORMATION_MESSAGE);
                break;

            case "2":
                strA = JOptionPane.showInputDialog(null,
                        "The system of equations should have the form of" + "\nax + by = c" + "\ndx + ey = f" + "\nEnter a:", "System of first-degree equations with two variables", JOptionPane.INFORMATION_MESSAGE);
                a = Double.parseDouble(strA);

                strB = JOptionPane.showInputDialog(null,
                        "The system of equations should have the form of" + "\nax + by = c" + "\ndx + ey = f" + "\nEnter b:", "System of first-degree equations with two variables", JOptionPane.INFORMATION_MESSAGE);
                b = Double.parseDouble(strB);

                strC = JOptionPane.showInputDialog(null,
                        "The system of equations should have the form of" + "\nax + by = c" + "\ndx + ey = f" + "\nEnter c:", "System of first-degree equations with two variables", JOptionPane.INFORMATION_MESSAGE);
                c = Double.parseDouble(strC);

                strD = JOptionPane.showInputDialog(null,
                        "The system of equations should have the form of" + "\nax + by = c" + "\ndx + ey = f" + "\nEnter d:", "System of first-degree equations with two variables", JOptionPane.INFORMATION_MESSAGE);
                d = Double.parseDouble(strD);

                strE = JOptionPane.showInputDialog(null,
                        "The system of equations should have the form of" + "\nax + by = c" + "\ndx + ey = f" + "\nEnter e:", "System of first-degree equations with two variables", JOptionPane.INFORMATION_MESSAGE);
                e = Double.parseDouble(strE);

                strF = JOptionPane.showInputDialog(null,
                        "The system of equations should have the form of" + "\nax + by = c" + "\ndx + ey = f" + "\nEnter f:", "System of first-degree equations with two variables", JOptionPane.INFORMATION_MESSAGE);
                f = Double.parseDouble(strF);

                double d1, d2, d0;
                d1 = c * e - f * b;
                d2 = a * f - d * c;
                d0 = a * e - d * b;
                if (d0 == 0 && (d1 == 0 || d2 == 0)) {
                        JOptionPane.showMessageDialog(null, "Indefinitely Many Solutions",
                        "Result", JOptionPane.INFORMATION_MESSAGE);
                } else if (d0 == 0 && d1 != 0 && d2 !=0) {
                        JOptionPane.showMessageDialog(null, "No Solution",
                        "Result", JOptionPane.INFORMATION_MESSAGE);
                } else {
                JOptionPane.showMessageDialog(null, (a) + "x + " + (b) +"y = " + (c)+ "\n" + 
                        (d) + "x + " + (e) + "y = "+ (f) +
                        "\n=> x = " + (d1/d0) + "\n\ty = " + (d2/d0),
                        "Result", JOptionPane.INFORMATION_MESSAGE);
                }
                break;
                
            case "3":
                strA = JOptionPane.showInputDialog(null,
                "The second-degree equation should have the form of" + "\nax^2 + bx + c = 0" + "\nEnter a:", "Second-degree equation with one variables", JOptionPane.INFORMATION_MESSAGE);
                a = Double.parseDouble(strA);
                if (a == 0) {
                JOptionPane.showMessageDialog(null, "a cannot be 0", "Error", JOptionPane.INFORMATION_MESSAGE);
                break;
                }

                strB = JOptionPane.showInputDialog(null,
                "The second-degree equation should have the form of" + "\nax^2 + bx + c = 0" + "\nEnter b:", "Second-degree equation with one variables", JOptionPane.INFORMATION_MESSAGE);
                b = Double.parseDouble(strB);

                strC = JOptionPane.showInputDialog(null,
                "The second-degree equation should have the form of" + "\nax^2 + bx + c = 0" + "\nEnter c:", "Second-degree equation with one variables", JOptionPane.INFORMATION_MESSAGE);
                c = Double.parseDouble(strC);
            
                double delta = b * b - 4 * a * c;
                String message;
                if (delta > 0) {
                double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                message = "The equation has two real roots:\n x1 = " + x1 + ", x2 = " + x2;
                } else if (delta == 0) {
                double x = -b / (2 * a);
                message = "The equation has one real root:\n x = " + x;
                } else {
                double realPart = -b / (2 * a);
                double imaginaryPart = Math.sqrt(-delta) / (2 * a);
                message = "The equation has two complex roots:\n x1 = " + realPart + " + " + imaginaryPart + "i, x2 = " + realPart + " - " + imaginaryPart + "i";
                }

                JOptionPane.showMessageDialog(null, message, "Result", JOptionPane.INFORMATION_MESSAGE);
                break;
            default:
            break;
        }
    System.exit(0);
    }   
}
