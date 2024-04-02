package erincminareci.GaltonBoard;

import java.util.Random;

class RandomBallPlacer implements Runnable {
    final Data arguments;
    public RandomBallPlacer(Data arguments) {this.arguments = arguments;}

    @Override
    public void run() {

        Random random = new Random();

        synchronized (arguments) {

            int binNumber = 0;

            int pickNumber;

            for (int i=0; i < arguments.value.length; i++) {

                pickNumber = random.nextInt(2);

                if (pickNumber==1 && binNumber < arguments.value.length-1)

                    binNumber+= 1;
            }

            arguments.value[binNumber] += 1;
        }
    }
}
