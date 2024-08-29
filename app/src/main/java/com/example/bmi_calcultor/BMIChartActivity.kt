import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.bmi_calcultor.R
import java.io.File

class BMIChartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmichart)

        // Get reference to ImageView
        val imageView: ImageView = findViewById(R.id.bmiImageView)

        // Path to the downloaded image (replace this with the actual path where you saved the image)
        val imagePath = "/home/dev/BMI_Calcultor/app/src/main/res/drawable/image.jpg"  // Replace with actual path

        // Convert image file to Bitmap and set it to ImageView
        val imgFile = File(imagePath)
        if (imgFile.exists()) {
            val bitmap = BitmapFactory.decodeFile(imgFile.absolutePath)
            // Set the Bitmap to ImageView
            imageView.setImageBitmap(bitmap)
        } else {
            // Handle case if the image file is not found
            // You can set a default image or display a message
            Log.d("BMIChartActivity", "Image file not found: $imagePath");
        }
    }
}
