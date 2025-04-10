# Movie Rating Analysis - Scala + Spark

This project analyzes IMDb movie scores using Apache Spark. It reads a dataset of movie metadata from a CSV file and calculates the **mean** and **standard deviation** of IMDb scores per movie.

---

## 🔍 Dataset

- **Name:** `movie_metadata.csv`
- **Source:** [Kaggle: IMDb Dataset](https://www.kaggle.com/datasets/PromptCloudHQ/imdb-data)
- **Fields used:** `movie_title`, `imdb_score`

---

## 📊 Output

The program groups movies by `movie_title` and computes:

- Mean IMDb score (`mean_score`)
- Standard deviation of IMDb score (`stddev_score`)

Example output:

