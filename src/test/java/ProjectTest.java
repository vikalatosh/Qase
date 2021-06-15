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

    @Test
    public void deleteProject() {
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
        projectSettingsPage.clickDeleteProject();
        projectSettingsPage.clickDeleteProject();
        projectsPage.isPageOpened();
        projectsPage.checkProjectIsDeleted(project);
    }

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
        projectSettingsPage.changeProjectData(project);
        projectSettingsPage.clickUpdateSettings();
        projectSettingsPage.projectIsUpdated();
    }
}
