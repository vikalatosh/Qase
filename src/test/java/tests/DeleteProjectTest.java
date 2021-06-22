package tests;

import models.Project;
import models.ProjectFactory;
import org.testng.annotations.Test;
import tests.base.BaseTest;

public class DeleteProjectTest extends BaseTest {

    @Test(description = "Project should be deleted")
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
}
