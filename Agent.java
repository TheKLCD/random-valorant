import javax.swing.ImageIcon;

public class Agent{
  private ImageIcon selectedIcon;
  private ImageIcon unselectedIcon;
  private boolean selected;

  public Agent(String name){
    this.selectedIcon = new ImageIcon("images/agent-icons/"+name+"_icon.png");
    this.unselectedIcon = new ImageIcon("images/agent-icons/"+name+"_icon_unselected.png");
    this.selected = true;
  }

  public ImageIcon press(){
    selected = !selected;

    if(selected){
      return selectedIcon;
    }

    return unselectedIcon;
  }
  
  public boolean isSelected(){
    return selected;
  }

  public ImageIcon getSelectedIcon(){
    return selectedIcon;
  }
}