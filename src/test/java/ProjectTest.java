import models.Project;
import models.ProjectFactory;
import org.testng.annotations.Test;

public class ProjectTest extends BaseTest {

    @Test
    public void projectShouldBeCreated() {
        loginPage.openLoginPage();
        loginPage.isPageOpened();
        loginPage.login(user, password);
        projectsPage.isPageOpened();
        projectsPage.clickButtonCreateNewProject();
        projectListPage.isPageOpened();
        Project project = ProjectFactory.get();
        projectListPage.createProject(project);
        projectsPage.openProjectsPage();
        projectsPage.checkProject(project);
    }
}
