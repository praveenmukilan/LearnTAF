package test.resources;

/*  1:   */ 
/*  2:   */ 
/*  3:   import com.praveenms.test.automation.framework.keywordmodel.reader.IKeywordStore;
import com.praveenms.test.automation.framework.keywordmodel.reader.ReaderFactory;
 */
/*  5:   */ import java.io.File;
/*  6:   */ import java.util.List;

/*  7:   */ import org.openqa.selenium.WebDriver;

import com.menonvarun.test.automation.framework.keywordmodel.executor.KeywordFactory;
import com.menonvarun.test.automation.framework.keywordmodel.reader.IKeywordStore;
import com.menonvarun.test.automation.framework.keywordmodel.reader.ReaderFactory;
/*  8:   */ 
/*  9:   */ public class NewKeywordExecutor
/* 10:   */ {
/* 11:   */   WebDriver driver;
/* 12:   */   NewKeywordFactory keyfactory;
/* 13:   */   ReaderFactory readerFactory;
/* 14:   */   
/* 15:   */   public NewKeywordExecutor(WebDriver driver, File file, String... args)
/* 16:   */   {
/* 17:32 */     this.driver = driver;
/* 18:33 */     this.keyfactory = new NewKeywordFactory(driver);
/* 19:34 */     this.readerFactory = new ReaderFactory(file, args);
/* 20:   */   }
/* 21:   */   
/* 22:   */   public NewKeywordExecutor(File file, String... args)
/* 23:   */   {
/* 24:48 */     this(null, file, args);
/* 25:   */   }
/* 26:   */   
/* 27:   */   public NewKeywordExecutor(File file, List<String> arguments)
/* 28:   */   {
/* 29:52 */     this(null, file, arguments);
/* 30:   */   }
/* 31:   */   
/* 32:   */   public NewKeywordExecutor(WebDriver driver, File file, List<String> arguments)
/* 33:   */   {
/* 34:56 */     this(driver, file, (String[])arguments.toArray());
/* 35:   */   }
/* 36:   */   
/* 37:   */   public NewKeywordExecutor(File file)
/* 38:   */   {
/* 39:69 */     this(null, file, (String[])null);
/* 40:   */   }
/* 41:   */   
/* 42:   */   public NewKeywordExecutor(WebDriver driver, File file)
/* 43:   */   {
/* 44:79 */     this(driver, file, (String[])null);
/* 45:   */   }
/* 46:   */   
/* 47:   */   public void execute()
/* 48:   */   {
/* 49:86 */     List<IKeywordStore> keys = this.readerFactory.getKeywordTestData();
/* 50:87 */     for (IKeywordStore key : keys)
/* 51:   */     {
/* 52:88 */       String keyword = key.getKeyword();
/* 53:89 */       List<Object> arguments = key.getArguments();
/* 54:90 */       this.keyfactory.executeKeyword(keyword, arguments.toArray());
/* 55:   */     }
/* 56:   */   }
/* 57:   */ }



/* Location:           C:\Users\VandP\Dropbox\Office\mig\Automation Framework\testautomationframework-0.0.1.jar

 * Qualified Name:     com.praveenms.test.automation.framework.keywordmodel.executor.KeywordExecutor

 * JD-Core Version:    0.7.0.1

 */
