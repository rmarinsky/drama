# Drama = UI Testing micro wrapper powered by Playwright

## Usage

```java

@Test
public void test() {
    open("https://google.com");
    $("[name=q]").fill("Selenide").pressEnter();
    $("#search").shouldHave(text("selenide.org"));
}
```

## Add dependency

### Gradle

Add to setting.gradle file:

```groovy
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        mavenCentral()
        maven { url 'https://jitpack.io' }
    }
}
```

or just add to repositories section in build.gradle to repositories block:

```groovy
repositories {
    maven { url 'https://jitpack.io' }
}
```

and to dependencies section in build.gradle file:

```groovy
implementation 'com.github.rmarinsky:drama:0.35'
```

### Maven

```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
```

and to dependencies section:

```xml
<dependency>
    <groupId>com.github.rmarinsky</groupId>
    <artifactId>drama</artifactId>
    <version>0.31</version>
</dependency>
```