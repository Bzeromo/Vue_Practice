<template>
    <div>
        <header>
            <nav>
                <RouterLink to="/">Home</RouterLink>  |
                <RouterLink to="/youtube">Youtube</RouterLink>  |
                <RouterLink :to="{name: 'boardList'}">BoardList</RouterLink>  |
                <RouterLink :to="{name: 'boardCreate'}">BoardCreate</RouterLink>
            </nav>
        </header>
    </div>
</template>

<script setup>

</script>

<style scoped>
    nav {
        padding: 30px;
    }

    nav a {
        text-decoration: none;
        font-weight: bold;
        color: black;
    }

    nav a.router-link-exact-active {
        color: rgb(26, 207, 26);
    }
</style>