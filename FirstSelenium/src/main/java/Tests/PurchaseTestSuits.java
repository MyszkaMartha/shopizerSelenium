package Tests;

import Infoshare.HandbagCataloug;
import categories.OrderRevue;
import categories.PurchaseTests;
import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Categories.class)
@Categories.IncludeCategory(OrderRevue.class)
@Suite.SuiteClasses(HandbagCataloug.class)

public class PurchaseTestSuits {
}
