package ninja.bryansills.tvplayground

import android.content.Context
import android.view.ContextThemeWrapper
import androidx.leanback.widget.ImageCardView
import com.bumptech.glide.Glide

class HatPresenter(
    context: Context
) : AbstractCardPresenter<ImageCardView, Hat>(
    ContextThemeWrapper(context, R.style.DefaultCardTheme)
) {
    override fun onCreateView(): ImageCardView {
        return ImageCardView(context)
    }

    override fun onBindViewHolder(card: Hat, cardView: ImageCardView) {
        cardView.titleText = card.name
        cardView.contentText = "Color: ${card.color} Height: ${card.height}"
        Glide.with(context).load(R.drawable.ic_android_yellow_64dp).into(cardView.mainImageView)
    }
}
