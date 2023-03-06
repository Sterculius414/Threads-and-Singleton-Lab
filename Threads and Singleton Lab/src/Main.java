import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        LazyInitializedSingleton instanceOne = LazyInitializedSingleton.getInstance();

        RunningTime R1 = new RunningTime("Thread-1");
        RunningTime R2 = new RunningTime("Thread-2");
        RunningTime R3 = new RunningTime("Thread-3");
        R1.start();
        R2.start();
        R3.start();

        instanceOne = LazyInitializedSingleton.getInstance();
            ObjectOutput out = new ObjectOutputStream(new FileOutputStream(
                    "filename.ser"));
            out.writeObject(instanceOne);
            out.close();

        ObjectInput in = new ObjectInputStream(new FileInputStream(
                "filename.ser"));
        LazyInitializedSingleton instanceTwo = (LazyInitializedSingleton) in.readObject();
            in.close();

        System.out.println("instanceOne hashCode="+instanceOne.hashCode());
        System.out.println("instanceTwo hashCode="+instanceTwo.hashCode());

        }
    }

