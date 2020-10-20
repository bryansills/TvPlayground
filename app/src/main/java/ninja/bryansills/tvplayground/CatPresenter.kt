package ninja.bryansills.tvplayground

import android.content.Context
import android.view.ContextThemeWrapper
import androidx.leanback.widget.ImageCardView
import com.bumptech.glide.Glide

class CatPresenter(
    context: Context
) : AbstractCardPresenter<ImageCardView, Cat>(
    ContextThemeWrapper(context, R.style.DefaultCardTheme)
) {
    override fun onCreateView(): ImageCardView {
        return ImageCardView(context)
    }

    override fun onBindViewHolder(card: Cat, cardView: ImageCardView) {
        cardView.titleText = card.name
        cardView.contentText = "Age: ${card.age} Breed: ${card.breed}"
        Glide.with(context).load(R.drawable.ic_android_yellow_64dp).into(cardView.mainImageView)
    }
}
