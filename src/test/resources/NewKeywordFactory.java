package test.resources;
/*  1:   */ 
/*  2:   */ 
/*  3:   */ import com.menonvarun.test.automation.framework.config.DefaultConfig;
/*  4:   */ import com.menonvarun.test.automation.framework.keywordmodel.KeywordException;
/*  5:   */ import com.menonvarun.test.automation.framework.keywordmodel.keywords.IKeyword;
/*  6:   */ import java.lang.reflect.Constructor;
/*  7:   */ import java.lang.reflect.InvocationTargetException;
/*  8:   */ import java.util.ArrayList;
/*  9:   */ import java.util.List;
/* 10:   */ import org.openqa.selenium.WebDriver;
public class NewKeywordFactory {


	/* 11:   */ 
	/* 12:   */ 
	/* 13:   */ 
	/* 14:22 */   DefaultConfig config = DefaultConfig.getDefaultConfig();
	/* 15:   */   List<IKeyword> keywordClassObjects;
	/* 16:   */   WebDriver driver;
	/* 17:   */   
	/* 18:   */   public NewKeywordFactory(WebDriver driver)
	/* 19:   */   {
	/* 20:27 */     this.driver = driver;
	/* 21:28 */     this.keywordClassObjects = getKeywordImplementations();
	/* 22:   */   }
	/* 23:   */   
	/* 24:   */   private List<IKeyword> getKeywordImplementations()
	/* 25:   */   {
	/* 26:32 */     String[] keywordClasses = this.config.getConfigValue("listeners").split(",");
	/* 27:33 */     ClassLoader cloader = getClass().getClassLoader();
	/* 28:34 */     List<Class<?>> listenerClasses = new ArrayList();
	/* 29:35 */     List<IKeyword> keywordClsObjs = new ArrayList();
	/* 30:36 */     for (String keywordClass : keywordClasses) {
	/* 31:   */       try
	/* 32:   */       {
	/* 33:38 */         Class<?> cls = cloader.loadClass(keywordClass);
	/* 34:39 */         listenerClasses.add(cls);
	/* 35:   */       }
	/* 36:   */       catch (ClassNotFoundException e)
	/* 37:   */       {
	/* 38:41 */         throw new KeywordException("Unable to find class with name as mentione in listner property: " + keywordClass + " Make sure the class is present in the classpath.");
	/* 39:   */       }
	/* 40:   */     }
	/* 41:46 */     for (Class<?> cls : listenerClasses) {
	/* 42:47 */       if (IKeyword.class.isAssignableFrom(cls))
	/* 43:   */       {
	/* 44:48 */         IKeyword obj = null;
	/* 45:   */         try
	/* 46:   */         {
	/* 47:50 */           Constructor<?> constructor = cls.getConstructor(new Class[] { WebDriver.class });
	/* 48:   */           
	/* 49:52 */           obj = (IKeyword)constructor.newInstance(new Object[] { this.driver });
	/* 50:   */         }
	/* 51:   */         catch (IllegalAccessException|InstantiationException|SecurityException|NoSuchMethodException|IllegalArgumentException|InvocationTargetException e)
	/* 52:   */         {
	/* 53:56 */           throw new KeywordException("Unable to find a constructor that accepts the WebDriver object for the keyword class:" + cls.getName());
	/* 54:   */         }
	/* 55:60 */         if (obj != null) {
	/* 56:61 */           keywordClsObjs.add(obj);
	/* 57:   */         }
	/* 58:   */       }
	/* 59:   */     }
	/* 60:66 */     return keywordClsObjs;
	/* 61:   */   }
	/* 62:   */   
	/* 63:   */   public void executeKeyword(String keyword, Object[] args)
	/* 64:   */   {
	/* 65:76 */     boolean executed = false;
	/* 66:77 */     for (IKeyword keywordCls : this.keywordClassObjects)
	/* 67:   */     {
	/* 68:78 */       boolean supported = keywordCls.isSupported(keyword, args);
	/* 69:79 */       if (supported)
	/* 70:   */       {
	/* 71:80 */         keywordCls.execute(keyword, args);
	/* 72:81 */         executed = true;
	/* 73:   */       }
	/* 74:   */     }
	/* 75:84 */     if (!executed) {
	/* 76:85 */       throw new KeywordException("Unable to find any keyword class that support keyword: \"" + keyword + "\" and arguments: \"" + args + "\".");
	/* 77:   */     }
	/* 78:   */   }
	/* 79:   */ 



	/* Location:           C:\Users\VandP\Dropbox\Office\mig\Automation Framework\testautomationframework-0.0.1.jar

	 * Qualified Name:     com.praveenms.test.automation.framework.keywordmodel.executor.KeywordFactory

	 * JD-Core Version:    0.7.0.1

	 */
	
	
}
