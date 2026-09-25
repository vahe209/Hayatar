# Project: Hayatar — learn to read and write Armenian

A mobile app that teaches Armenian to heritage learners in the diaspora —
people who often speak some Armenian at home but cannot read or write it.
Learning order: letters -> words -> word pairs -> simple sentences -> harder.

Solo developer, fluent in Kotlin, new to Compose Multiplatform, working with AI.

## Stack

- Kotlin Multiplatform + Compose Multiplatform (shared UI), Android + iOS
- Kotlin 2.4.20, AGP 9.1.1, Compose Multiplatform 1.12.1, Material3
- Package: `am.hayatar.app` — never `com.example`, Google Play rejects it
- State: `remember` / `mutableStateOf` for local state; a ViewModel only where
  state outlives a screen. No DI framework until it actually hurts.
- Local storage only in v1. NO backend, NO accounts, NO network calls.
- Subscriptions later via RevenueCat `purchases-kmp`. Not in v1.

## Module layout

```
shared/src/commonMain/kotlin/am/hayatar/app/
  theme/Theme.kt      # ALL design tokens — the only place with hex values
  models/             # plain data classes
  data/               # loading, parsing, persistence
  screens/            # one file per screen
  widgets/            # reusable composables
shared/src/commonMain/composeResources/
  files/              # lesson JSON
  font/               # Armenian fonts once added
androidApp/           # Android entry point only
iosApp/               # Xcode project, iOS entry point only
```

Put shared code in `shared`. `androidApp` and `iosApp` hold entry points and
platform configuration, nothing else.

## Non-negotiable rules

1. **Never hardcode a color, text size, radius or spacing in a screen.**
   Everything comes from `theme/Theme.kt`:
   - `MaterialTheme.colorScheme.primary`
   - `AppTheme.colors.success` for the semantics Material3 does not cover
   - `AppSpacing.md`, `AppRadius.card`, `AppSize.minTapTarget`
   If a value is missing, add it to Theme.kt — do not inline it.

2. **One screen = one file** under `screens/`. Reusable pieces go in `widgets/`.

3. **Armenian text uses its own style**: `LetterDisplay` for a single large
   letter, `ArmenianBody` for words and sentences. Armenian renders through the
   system font fallback for now; bundling Noto Serif Armenian in
   `composeResources/font/` will make it consistent across platforms.

4. **Content is data, never code.** Lessons, words and sentences live in JSON in
   `composeResources/files/`, keyed by a stable id. Never hardcode lesson content
   inside a composable.

5. **Every tap target is at least 48.dp** (`AppSize.minTapTarget`).

6. **Both themes always.** Anything added must look right in light and dark.

7. **No `expect`/`actual` unless a platform API genuinely differs.** Most of this
   app is pure common code. Reach for platform code only for audio and storage.

## Color roles — each color has exactly one job

- `colorScheme.primary` — interactive: buttons, selected state, completed lesson
- `colorScheme.secondary` — attention: current lesson, hint, emphasis
- `AppTheme.colors.success` — correct answer only
- `AppTheme.colors.danger` — wrong answer only
- `AppTheme.colors.streak` — streak and achievements only

Never reuse one of these for a second purpose.

## Working in this repo

- Git is initialised. Run git from the Mac terminal, not from tooling that
  cannot delete files — git needs to remove its own lock files.
- After any change, say which files changed and what to run to see it.
- Prefer a longer, obvious composable over a short clever one.
- If a request needs a backend, say so and propose the local-only version first.
