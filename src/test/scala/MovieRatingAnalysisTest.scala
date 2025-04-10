def testComputeStats(): Unit = {
  val spark = SparkSession.builder().appName("Test").master("local[*]").getOrCreate()
  import spark.implicits._

  val sampleData = Seq(
    (1, 101, 4.0),
    (2, 101, 5.0),
    (3, 102, 3.0),
    (4, 102, 3.0)
  ).toDF("userId", "movieId", "rating")

  val result = MovieRatingAnalysis.computeStats(sampleData)
  result.show()

  spark.stop()
}
