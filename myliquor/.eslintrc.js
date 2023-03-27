module.exports = {
  env: {
    node: true,
    es6: true,
  },
  extends: [
    'eslint:recommended',
    'plugin:react/recommended',
    'plugin:react-hooks/recommended',
    'plugin:@typescript-eslint/eslint-recommended',
    'plugin:@typescript-eslint/recommended',
    'plugin:@typescript-eslint/recommended-requiring-type-checking',
    'plugin:import/recommended',
    'airbnb',
    'airbnb/hooks',
    'prettier',
  ],
  parser: '@typescript-eslint/parser',
  parserOptions: {
    project: './tsconfig.json',
    ecmaFeatures: {
      jsx: true,
    },
    ecmaVersion: 12,
    sourceType: 'module',
  },
  plugins: ['react', 'react-hooks', '@typescript-eslint', 'prettier'],
  rules: {
    indent: 'off',
    'linebreak-style': ['error', 'unix'],
    quotes: ['error', 'single'],
    semi: ['error', 'always'],
    'no-empty-function': 'off',
    '@typescript-eslint/no-empty-function': 'off',
    'prettier/prettier': [
      'error',
      {
        arrowParens: 'always',
      },
    ],
    'react/jsx-fragments': ['off', 'element'],
    'react-hooks/rules-of-hooks': 'error',
    '@typescript-eslint/no-floating-promises': 'off',
    'react-hooks/exhaustive-deps': 'error',
    'no-console': 'off',

    'import/named': 'off',
    'import/no-cycle': 'off', // THIS IS EXPENSIVE COMPUTATION
    'import/prefer-default-export': 'off',
    'import/extensions': 'off',
    'import/export': 'off',
    'import/no-unresolved': 'off',
    'import/no-extraneous-dependencies': 'off',
    'import/namespace': 'off',

    'no-use-before-define': 'off',
    '@typescript-eslint/no-use-before-define': ['error'],
    'react/function-component-definition': 'off',
    'arrow-body-style': ['error', 'always'],

    'react/jsx-filename-extension': ['warn', {extensions: ['.ts', '.tsx']}],
    'react/prop-types': 'off',
    'react/jsx-wrap-multilines': 'off',
    'react/jsx-props-no-spreading': 'off',
    'react/display-name': 'off',
    'react/require-default-props': 'off',
    'react/no-unused-prop-types': 'warn',
    'react/no-array-index-key': 'warn',
    'react/jsx-no-literals': ['warn', {ignoreProps: true}],
    'space-in-brackets': 'off',
  },
  settings: {
    react: {
      version: 'detect',
    },
  },
};
