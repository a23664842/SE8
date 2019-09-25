import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

public class TableColor extends DefaultTableCellRenderer
{
    private int week;
    private Color c_font;
    private Color c_background;
    Processor processor = new Processor();
        
    public TableColor()
    {
            set_color(0, Color.BLACK, Color.WHITE);
    }
 
    public TableColor(int week, Color font, Color back)
    {
            set_color(week, font, back);
    }
    
 
    public void set_color(int week, Color font, Color back)
    {
        this.week=week;
        c_font=font;
        c_background=back;
    }
 
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,int row, int column)
    {
        Component   cell   =   super.getTableCellRendererComponent(table,   value,   isSelected,   hasFocus,   row,   column);
        
        if(processor.getCheckornot().get(week*40+row+column*8).equalsIgnoreCase("true")&&
        		!processor.getScheldules().get(week).get(row+column*8).equalsIgnoreCase("µL"))
        {
        	
            cell.setBackground(c_background);          
        }
        else {
        	cell.setBackground(Color.gray);
        }
        
        return   cell;
    }
}