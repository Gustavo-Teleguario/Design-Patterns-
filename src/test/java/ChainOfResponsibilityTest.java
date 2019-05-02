import HA_03.*;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
/**
 * Created by Maynor Teleguario
 * 30247228
 * Design Patterns Summer Semester 2019
 * Homework No 03
 * University of Kassel
 */
public class ChainOfResponsibilityTest {

    @Test
    public void test() throws IOException {
        System.out.println("***********************************************");
        System.out.println("|                                             |");
        System.out.println("|                 TEST BEGINN                 |");
        System.out.println("|                                             |");
        System.out.println("*************************** *******************");

        Assembler assembler = new Assembler("src/main/java/HA_03/command");

        CommandHandler ldc = new Ldc(assembler);
        CommandHandler mult = new Mult(assembler);
        CommandHandler store = new Store(assembler);
        CommandHandler ld = new Ld(assembler);
        CommandHandler print = new Print(assembler);

        ArrayList<CommandHandler> commandHandlerList = new ArrayList<CommandHandler>();

        commandHandlerList.add(ldc);
        commandHandlerList.add(mult);
        commandHandlerList.add(store);
        commandHandlerList.add(ld);
        commandHandlerList.add(print);

        assembler.setCommandHandlerList(commandHandlerList);
        System.out.println("Command Print am Ende der Liste\n");
        assembler.execute();

        System.out.println("Command Mult , Store X und Ld X \n");
        assertEquals("[42]", assembler.getStack().toString());
        System.out.println("HashMap speicher: "+ assembler.getCommandHandlerList().get(2).getSpeicher());

        while (!assembler.getStack().empty()) {
            assembler.getStack().pop();
        }
        /**
         * Stack is Empty
         */
        assertEquals(true, assembler.getStack().empty());

        System.out.println("***********************************************");
        System.out.println("|                                             |");
        System.out.println("|                 TEST END                    |");
        System.out.println("|                                             |");
        System.out.println("*************************** *******************");
    }
}
