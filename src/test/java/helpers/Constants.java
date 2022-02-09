package helpers;

public class Constants {
    // Некоторые элементы приходится искать некрасивым способом.
    // Для читабельности кода вынесла длинные пути в константы
    public static String minusXpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/" +
            "android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/" +
            "android.widget.LinearLayout/android.widget.LinearLayout[4]/android.widget.RelativeLayout/" +
            "android.widget.LinearLayout/android.widget.ImageSwitcher/android.widget.ImageView";
    public static String minusInAmountBalance="\t\n" +
            "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/" +
            "android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/" +
            "android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.RelativeLayout/" +
            "android.widget.LinearLayout/android.widget.ImageSwitcher/android.widget.ImageView";
    public static String defaultCurrency = "AED (United Arab Emirates dirham)";
    public static String reportPageTitle = "By Period (Income/Expenses)";
    public static String xp = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/" +
            "android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ListView/" +
            "android.view.View[1]";
}
