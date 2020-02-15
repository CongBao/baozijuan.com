<template>
  <div>
    <b-navbar toggleable="lg" type="dark" variant="dark" fixed="top">
      <b-navbar-brand href="#">Time Gallery</b-navbar-brand>

      <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>

      <b-collapse id="nav-collapse" is-nav>
        <b-navbar-nav>
          <b-nav-text>v2.0</b-nav-text>
        </b-navbar-nav>

        <!-- Right aligned nav items -->
        <b-navbar-nav class="ml-auto">
          <b-nav-item-dropdown right>
            <!-- Using 'button-content' slot -->
            <template v-slot:button-content>
              <b-icon icon="person-fill" aria-hidden="true"></b-icon>
            </template>
            <b-dropdown-text>Visitor</b-dropdown-text>
            <b-dropdown-divider></b-dropdown-divider>
            <b-dropdown-item href="#">Sign In</b-dropdown-item>
          </b-nav-item-dropdown>
          <b-nav-form>
            <b-input-group>
              <b-form-input size="sm" placeholder="Search"></b-form-input>
              <b-input-group-append>
                <b-button size="sm" type="submit" variant="outline-light">
                  <b-icon icon="search"></b-icon>
                </b-button>
              </b-input-group-append>
            </b-input-group>
          </b-nav-form>
        </b-navbar-nav>
      </b-collapse>
    </b-navbar>
  </div>
</template>

<script>
export default {
  name: "NavBar"
}
</script>