package week13_visitor;

import java.util.ArrayList;
import java.util.Random;

// Element  (Element)
// defines an Accept operation that takes a visitor a
// as an argument.

interface Element {
    public void Accept(Visitor visitor);
}

//"Visitor" declares a Visit operation for each class of ConcreteElement in the
//object structure. The operation's name and signature identifies the
//class that sends the Visit request to the visitor. That lets the
//visitor determine the concrete class of the element being visited.
//Then the visitor can access the elements directly through its particular
//interface
//
//"Visitor"
interface Visitor {
    public void Visit(BodyWorlds bodyWorlds);

    public void Visit(KingTutankhamun kingTutankhamun);

    public void Visit(Titanic titanic);
    public void Visit(Viking viking);
}

//ConcreteElement  (Museum)
//implements an Accept operation that
//takes a visitor as an argument

abstract class Museum implements Element {
    private String name;
    private boolean continueApprove;
    private int noOfVisitors;
    // Constructor

    public Museum(String name) {
        this.name = name;
        this.continueApprove = continueApprove;
        this.noOfVisitors = noOfVisitors;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isContinueApprove() {
        return continueApprove;
    }

    public void setContinueApprove(boolean continueApprove) {
        this.continueApprove = continueApprove;
    }

    public int getNoOfVisitors() {
        return noOfVisitors;
    }

    public void setNoOfVisitors(int noOfVisitors) {
        this.noOfVisitors = noOfVisitors;
    }
}

class BodyWorlds extends Museum {
    public BodyWorlds(String name) {
        super(name);
    }


    public void Accept(Visitor visitor) {
        visitor.Visit(this);
    }
}

class KingTutankhamun extends Museum {
    public KingTutankhamun(String name) {
        super(name);
    }

    public void Accept(Visitor visitor) {
        visitor.Visit(this);
    }

}

class Titanic extends Museum {
    public Titanic(String name) {
        super(name);
    }

    public void Accept(Visitor visitor) {
        visitor.Visit(this);
    }
}
class Viking extends Museum {
    public Viking(String name) {
        super(name);
    }

    public void Accept(Visitor visitor) {
        visitor.Visit(this);
    }
}

// ObjectStructure can enumerate its elements  may provide a
// high-level interface to allow the visitor to visit its elements
// may either be a Composite (pattern) or a collection such as a
// list or a set
//
// ObjectStructure  (Museums)
class Museums {
    public void Add(Museum Museum) {
        Museums.add(Museum);
    }

    ;

    public void Remove(Museum Museum) {
        for (int i = 0; i < Museums.size(); i++) {
            if (Museums.get(i).getName() == Museum.getName()) {
                Museums.remove(i);
                return;
            }
        }
    }

    public void Accept(Visitor visitor) {
        // elements accept the visitor
        for (Museum e : Museums) {
            e.Accept(visitor);
        }
    }

    private ArrayList<Museum> Museums = new ArrayList<Museum>();
};


// ConcreteVisitors (CountVisitor, VacationVisitor)
// implements each operation declared by Visitor. Each operation implements
// a fragment of the algorithm defined for the corresponding class or object
// in the structure. ConcreteVisitor provides the context for the algorithm
// and stores its local state. This state often accumulates results during
// the traversal of the structure.
//
// "ConcreteVisitor 1"
class CountVisitor implements Visitor {
    Random random=new Random();
    public void Visit(BodyWorlds bodyWorlds) {
        bodyWorlds.setNoOfVisitors(random.nextInt(100)+1);
        System.out.print(bodyWorlds.getName() + "'s number of Visitors:");
        System.out.printf("%6.2f\n", bodyWorlds.getNoOfVisitors());
    }

    public void Visit(KingTutankhamun kingTutankhamun) {
        kingTutankhamun.setNoOfVisitors(random.nextInt(75)+1);
        System.out.print(kingTutankhamun.getName() + "'s number of Visitors:");
        System.out.printf("%6.2f\n",kingTutankhamun .getNoOfVisitors());
    }

    public void Visit(Titanic titanic) {
        titanic.setNoOfVisitors(random.nextInt(250)+1);
        System.out.print(titanic.getName() + "'s number of Visitors:");
        System.out.printf("%6.2f\n",titanic .getNoOfVisitors());
    }
    public void Visit(Viking viking) {
        viking.setNoOfVisitors(random.nextInt(200)+1);
        System.out.print(viking.getName() + "'s number of Visitors:");
        System.out.printf("%6.2f\n",viking .getNoOfVisitors());
    }
}
// "ConcreteVisitor 2"

class ApprovedVisitor implements Visitor {
    public void Visit(BodyWorlds element) {

        if(element.getNoOfVisitors()>75){
            element.setContinueApprove(true);

        } System.out.println(element.isContinueApprove()+"-BodyWorlds");
    }

    public void Visit(KingTutankhamun element) {

        if(element.getNoOfVisitors()>100){
            element.setContinueApprove(true);

        }System.out.println(element.isContinueApprove()+"-KingTutankhamun");
    }

    public void Visit(Titanic element) {
        // Provide 7 extra vacation days
        if(element.getNoOfVisitors()>250){
            element.setContinueApprove(true);

        } System.out.println(element.isContinueApprove()+"-Titanic");
    }
    public void Visit(Viking element) {
        // Provide 7 extra vacation days
        if(element.getNoOfVisitors()>200){
            element.setContinueApprove(true);

        } System.out.println(element.isContinueApprove()+"-Viking");
    }
}
class SecondChanceVisitor implements Visitor {
    @Override
    public void Visit(BodyWorlds element) {
        if(element.getNoOfVisitors()<75){
            element.setNoOfVisitors(element.getNoOfVisitors()+10);

        } System.out.println(element.getNoOfVisitors()+"-BodyWorlds");

    }

    @Override
    public void Visit(KingTutankhamun element) {
        if(element.getNoOfVisitors()<100){
            element.setNoOfVisitors(element.getNoOfVisitors()+25);

        } System.out.println(element.getNoOfVisitors()+"-KingTutankhamun");
    }

    @Override
    public void Visit(Titanic element) {
        if(element.getNoOfVisitors()<100){
            element.setNoOfVisitors(element.getNoOfVisitors()+50);

        } System.out.println(element.getNoOfVisitors()+"-Titanic");
    }
    @Override
    public void Visit(Viking element) {
        if(element.getNoOfVisitors()<200){
            element.setNoOfVisitors(element.getNoOfVisitors()+30);

        } System.out.println(element.getNoOfVisitors()+"-Vikings");

    }
}

public class VisitorPattern {
    public static void main(String[] args) {
        Museums e = new Museums();
        e.Add(new BodyWorlds("BodyWorlds"));
        e.Add(new KingTutankhamun("KingTutankhamun"));
        e.Add(new Titanic("Titanic"));

        // Museums are 'visited'
        e.Accept(new CountVisitor());
        e.Accept(new ApprovedVisitor());
        e.Accept(new SecondChanceVisitor());
        e.Accept(new ApprovedVisitor());
    }
}