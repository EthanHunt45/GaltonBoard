package erincminareci.GaltonBoard;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;

public class GaltonBoardMain {

    public static void main(String[] args) throws CmdLineException, InterruptedException {

        Options options= new Options();

        CmdLineParser parser= new CmdLineParser(options);

        parser.parseArgument(args);

        int sum=0;

        Data arguments = new Data();

        arguments.value= new int[options.numBins];

        for (int i = 0; i < options.numThreads; i++) {

            RandomBallPlacer randomPlacer = new RandomBallPlacer(arguments);

            Thread thread_i = new Thread(randomPlacer);

            thread_i.start();

            thread_i.join();
        }

        for (int i = 0; i < arguments.value.length; i++) {

            System.out.println(i + "      " + arguments.value[i]);

            sum+=arguments.value[i];

        }

        System.out.println("Number of requested thread: " + options.numThreads);

        System.out.println("Sum of bin values: "+ sum);

        if(sum==options.numThreads)

            System.out.println("Nice work! Both of them are equal!");
    }
}

