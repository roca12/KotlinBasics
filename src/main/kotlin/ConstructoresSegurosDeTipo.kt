import java.awt.EventQueue
import javax.swing.JFrame
import javax.swing.JMenu
import javax.swing.JMenuBar
import javax.swing.JMenuItem

object ConstructoresSegurosDeTipo {

    fun JFrame.menuBar(init:JMenuBar.() ->Unit){
        var menubar=JMenuBar()
        menubar.init()
        setJMenuBar(menubar)
    }
    fun JMenuBar.menu(caption:String, init:JMenu.()->Unit) {
        val menu =JMenu(caption)
        menu.init()
        add(menu)
    }
    fun JMenu.menuItem(caption: String,init: JMenuItem.() -> Unit){
        val menuitem=JMenuItem(caption)
        menuitem.init()
        add(menuitem)
    }

    class MyFrame:JFrame(){
        init {
            defaultCloseOperation = JFrame.EXIT_ON_CLOSE
            setSize(300, 200)
            setLocationRelativeTo(null)
            menuBar{
                menu("Menu1"){
                    menuItem("MenuItem1"){

                    }
                    menuItem("MenuItem2"){

                    }

                }
                menu("Menu2"){
                    menuItem("MenuItem3"){

                    }
                    menuItem("MenuItem4"){

                    }

                }
            }
        }
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val frame = MyFrame()
        frame.isVisible = true
    }

}
