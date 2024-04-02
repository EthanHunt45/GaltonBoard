package erincminareci.GaltonBoard;

import org.kohsuke.args4j.Option;

class Options {
    @Option(name = "-numThread", usage = "Number of threads")
    int numThreads;
    @Option(name = "-numBins", usage = "Number of bins")
    int numBins;
}
