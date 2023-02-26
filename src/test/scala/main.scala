import io.circe._
import io.circe.parser._
import io.circe.syntax._
import scala.io.Source

object CsvToJsonConverter {
  def convert(csvFilePath: String): String = {
    val lines = Source.fromFile(csvFilePath).getLines()
    val header = lines.next().split(",").map(_.trim)
    val jsonString = CsvToJsonConverter.convert("D:\\ProyectoScala\\src\\main\\scala\\categories.csv")
    val jsonArray = lines.map(line => {
      val values = line.split(",").map(_.trim)
      (header zip values).toMap.asJson
    }).toList.asJson
    jsonArray.spaces2
  }
}
