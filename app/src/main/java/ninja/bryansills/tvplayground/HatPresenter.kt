package ninja.bryansills.tvplayground

import android.content.Context
import androidx.leanback.widget.ImageCardView

class HatPresenter(context: Context) : AbstractCardPresenter<ImageCardView, Hat>(context) {
    override fun onCreateView(): ImageCardView {
        return ImageCardView(context)
    }

    override fun onBindViewHolder(card: Hat, cardView: ImageCardView) {
        cardView.titleText = card.name
        cardView.contentText = "Color: ${card.color} Height: ${card.height}"
    }
}
