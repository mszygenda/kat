object SolutionComparator {
    def measure(name: String, dataSize: Int, code: () => Unit) = {
        val n = 1000;
        val start = System.currentTimeMillis();

        for (i <- 1 to n) {
            code.apply()
        }

        val end = System.currentTimeMillis();

        println (s"$name. for data $dataSize ($n times) took  ${end-start} milliseconds")
    }

    object Data {
        val lotOfA = (1 to 10000).map((_) => "a").mkString("")
        val dancingQueen = (1 to 2500).map((_) => "abba").mkString("")
        val abcd = (1 to 2500).map((_) => "abcd").mkString("")
        val somethingInTheMiddle = lotOfA + "c" + lotOfA
        val empty = ""
    }

    def warmUp(): Unit = {
        for (i <- 1 to 1000) {
            functional.Solution.solution("aba")
            iterative.Solution.solution("aba")
            iterative.SolutionNaive.solution("aba")
        }
    }

    def testCase(name: String, data: String) {
        println(s"\n** TestCase: $name **\n")

        println(s"Functional result: ${functional.Solution.solution(data)}")
        println(s"Iterative result: ${iterative.Solution.solution(data)}")
        println(s"Naive result: ${iterative.SolutionNaive.solution(data)}")

        println(s"\nMeasuring time.\n")

        measure("Functional solution", data.size, () => functional.Solution.solution(data))
        measure("Iterative solution", data.size, () => iterative.Solution.solution(data))
        measure("Naive solution", data.size, () => iterative.SolutionNaive.solution(data))
    }

    def main(args: Array[String]): Unit = {
        warmUp()

        testCase("<EMPTY>", Data.empty)

        testCase("...abba...", Data.dancingQueen)
        testCase("2 x ...abba...", Data.dancingQueen + Data.dancingQueen)

        testCase("...aaaaa...", Data.lotOfA)
        testCase("2 x ....aaaaa...", Data.lotOfA + Data.lotOfA)

        testCase("...abcd...", Data.abcd)
        testCase("2 x ...abcd...", Data.abcd + Data.abcd)

        testCase("...aaaaacaaaaa...", Data.somethingInTheMiddle)
        testCase("2 x ...aaaaacaaaaa...", Data.somethingInTheMiddle + Data.somethingInTheMiddle)
    }
}
