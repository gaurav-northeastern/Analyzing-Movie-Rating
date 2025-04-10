import org.apache.spark.sql.{DataFrame, SparkSession}
import org.apache.spark.sql.functions._

object MovieRatingAnalysis {

  def main(args: Array[String]): Unit = {
    // Initialize Spark session
    val spark = SparkSession.builder()
      .appName("Movie Rating Analysis")
      .master("local[*]")
      .getOrCreate()

    // Path to your CSV file
    val path = "data/movie_metadata.csv"

    // Load the CSV into a DataFrame
    val df = spark.read
      .option("header", "true")
      .option("inferSchema", "true")
      .csv(path)

    // Optional: Show schema and preview data
    println("Schema:")
    df.printSchema()

    println("Sample data:")
    df.select("movie_title", "imdb_score").show(10, truncate = false)

    // Compute mean and standard deviation of IMDb score per movie
    val result = computeStats(df)
    result.show(truncate = false)

    // Stop the Spark session
    spark.stop()
  }

  /**
    * Computes the mean and standard deviation of IMDb scores grouped by movie title.
    *
    * @param df Input DataFrame with movie metadata.
    * @return DataFrame with movie title, mean IMDb score, and standard deviation.
    */
  def computeStats(df: DataFrame): DataFrame = {
    df.groupBy("movie_title")
      .agg(
        avg("imdb_score").alias("mean_score"),
        stddev("imdb_score").alias("stddev_score")
      )
      .orderBy(desc("mean_score"))
  }
}
