package ir.dolphin.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.sql.SQLException;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = "ir.dolphin.*")
@PropertySource("classpath:database.properties")
public class PersistenceCfg {


    @Autowired
    private Environment env;

    @Bean(name = "datasource", destroyMethod = "getConnection")
    public DataSource dataSource() {
        try {
            ComboPooledDataSource dataSource = new ComboPooledDataSource();
            dataSource.setDriverClass(env.getProperty("hibernate.connection.driver_class"));
            dataSource.setJdbcUrl(env.getProperty("hibernate.connection.url"));
            dataSource.setMaxPoolSize(Integer.parseInt(env.getProperty("hibernate.c3p0.max_size")));
            dataSource.setMinPoolSize(Integer.parseInt(env.getProperty("hibernate.c3p0.min_size")));
            dataSource.setLoginTimeout(Integer.parseInt(env.getProperty("hibernate.c3p0.timeout")));
            dataSource.setMaxStatements(Integer.parseInt(env.getProperty("hibernate.c3p0.max_statements")));
            dataSource.setUser(env.getProperty("hibernate.connection.username"));
            dataSource.setPassword(env.getProperty("hibernate.connection.password"));
            return dataSource;
        } catch (PropertyVetoException e) {
            e.printStackTrace();
            return null;
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Bean
    public JpaTransactionManager jpaTransactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(  entityManagerFactoryBean().getObject());
        return transactionManager;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setJpaVendorAdapter(vendorAdaptor());
        entityManagerFactoryBean.setDataSource(dataSource());
        entityManagerFactoryBean.setPackagesToScan(new String[]{"ir.dolphin.*.entity"});
        entityManagerFactoryBean.setJpaProperties(jpaHibernateProperties());
        entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        return entityManagerFactoryBean;
    }

    private HibernateJpaVendorAdapter vendorAdaptor() {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setShowSql(true);
        return vendorAdapter;
    }

    private Properties jpaHibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
        properties.put("hibernate.format_sql", env.getProperty("hibernate.format_sql"));
        properties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
        properties.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
        return properties;
    }

}
