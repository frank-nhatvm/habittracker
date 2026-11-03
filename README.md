# HabitTracker

A Kotlin Multiplatform (KMP) habit-tracking application targeting Android and iOS, built with Compose Multiplatform, Room, and a clean layered architecture.

---

## Modules

| Module         | Description                                                  |
|----------------|--------------------------------------------------------------|
| `composeApp`   | Shared Compose Multiplatform UI (Android + iOS)              |
| `androidApp`   | Android-specific application entry point                     |
| `ht-data`      | Domain data models and repository interfaces                 |
| `ht-database`  | Room database, DAOs, and entity definitions                  |

---

## Developer Tools

### `document-file` — Inline KDoc Skill

A reusable agent skill that inserts missing KDoc comments into the **currently active Kotlin file** only. It is designed to keep documentation close to the source without modifying any other file.

#### How to invoke

1. Open any Kotlin file in the editor.
2. Open the GitHub Copilot chat panel.
3. Type and send:

```
/docfile
```

The skill reads the currently active file from editor context automatically — no need to paste a path or attach a prompt file manually.

#### What it does

- Scans the active file for every **public** `class`, `interface`, `object`, and `fun` declaration.
- Inserts a deterministic KDoc block immediately above each undocumented symbol.
- Uses slightly descriptive sentence templates — stable phrasing so repeated runs produce consistent text.
- Includes `@param`, `@return`, `@throws`, and threading/side-effect `Note:` lines where applicable.
- **Skips** any declaration already preceded by a KDoc block (`/** ... */`).
- **Skips** `private`, `internal`, `protected` declarations entirely.
- **Skips** `actual` counterparts of `expect` declarations — only the `expect` side is documented.

#### What it does NOT do

- Does not overwrite or merge existing KDoc.
- Does not touch any file other than the currently open one.
- Does not reorder, reformat, or alter logic in any way.

#### Idempotency

Running the skill twice on the same file produces no changes on the second run.

#### Covered symbol kinds

| Symbol kind                   | Documented |
|-------------------------------|------------|
| `class` / `data class`        | ✅          |
| `abstract class`              | ✅          |
| `sealed class`                | ✅          |
| `interface`                   | ✅          |
| `object` / `companion object` | ✅          |
| `fun` (public)                | ✅          |
| `suspend fun` (public)        | ✅ + Note   |
| `fun` returning `Flow<…>`     | ✅ + Note   |
| `@Composable fun`             | ✅ + Note   |
| `expect fun`                  | ✅          |
| `actual fun`                  | ❌ skipped  |
| `private` / `internal` decl   | ❌ skipped  |

#### Example — `Greeting.kt`

**Before:**
```kotlin
class Greeting {
    private val platform = getPlatform()

    fun greet(): String {
        return "Hello, ${platform.name}!"
    }
}
```

**After:**
```kotlin
/**
 * Provides a singleton-style greeter that composes a platform-aware greeting message.
 */
class Greeting {
    private val platform = getPlatform()

    /**
     * Returns a greeting string that includes the name of the current platform.
     *
     * @return A human-readable greeting string identifying the host platform.
     */
    fun greet(): String {
        return "Hello, ${platform.name}!"
    }
}
```

#### Skill source

The full skill definition, phrasing rules, scope rules, and additional examples live in:

```
.github/prompts/docfile.prompt.md
```

---

## Build & Run

### Android

```bash
./gradlew :androidApp:assembleDebug
```

### iOS

Open `iosApp/iosApp.xcodeproj` in Xcode and run on a simulator or device.

### Run all tests

```bash
./gradlew test
```

