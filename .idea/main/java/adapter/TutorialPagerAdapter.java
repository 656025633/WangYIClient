package adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.util.List;
/**
 * Created by Administrator on 2015/6/11.
 */
public class TutorialPagerAdapter  extends PagerAdapter {
    int resIDs[];
    List<ImageView> images;
    Context context;
    public TutorialPagerAdapter(int resIDs[],List<ImageView> images,Context context){
       this.images=images;
        this.resIDs=resIDs;
        this.context=context;
    }
    @Override
    public int getCount() {
        return resIDs.length;
    }
    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView imageView=new ImageView(context);
        //设置图片的属性
        imageView.setImageResource(resIDs[position]);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        ViewGroup.LayoutParams lp=new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
        );
        imageView.setLayoutParams(lp);
        //添加图片
        images.add(imageView);
        container.addView(imageView);
        return imageView;
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(images.get(position));
    }
}
