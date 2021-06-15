import models.Project;
import models.ProjectFactory;
import org.testng.annotations.Test;

public class UpdateProjectTest extends BaseTest {

    @Test
    public void updateProject() {
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
        projectsPage.openProjectDetailsPage(project);
        projectDetailsPage.isPageOpened();
        projectDetailsPage.openSettings();
        projectSettingsPage.isPageOpened();
        projectSettingsPage.changeProjectData();
        projectSettingsPage.clickUpdateSettings();
        projectSettingsPage.projectIsUpdated();
    }
}
