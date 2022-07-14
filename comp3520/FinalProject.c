#define _CRT_SECURE_NO_WARNINGS
// Visual studio gives errors on scanf without this line above.
#include <SDL2/SDL.h>
#include <GL/glew.h>    // needed for creating shapes
#include <GL/GLU.h>
#include <stdio.h>
#include <math.h>   // needed for fmax and fmin
#include <stdbool.h>
#include <time.h>   // for clock

#define ENABLE_LIGHTING

// Julia Garant
// Winter 2021
// 104987469

int SCREEN_WIDTH = 600;
int SCREEN_HEIGHT = 600;
float x = 0, z = 0, angle = 0, xTable = 0, zTable = 0, angle_table = 0;
float centerX = 0.3, centerY = 0.8, centerZ = -1;
bool lights_enabled[3] = { false };


// Drawing cubes
void drawCube(float r1, float g1, float b1, float r2, float g2, float b2) {
    /* Front */
    glBegin(GL_QUADS);
    glColor3f(r1, g1, b1);
    glNormal3f(0, 0, 1);

    glVertex3f(0.5, -0.5, -0.5);
    glVertex3f(0.5, 0.5, -0.5);
    glVertex3f(-0.5, 0.5, -0.5);
    glVertex3f(-0.5, -0.5, -0.5);

    /* Back */
    glNormal3f(0, 0, -1);

    glVertex3f(0.5, -0.5, 0.5);
    glVertex3f(0.5, 0.5, 0.5);
    glVertex3f(-0.5, 0.5, 0.5);
    glVertex3f(-0.5, -0.5, 0.5);

    /* Right */
    glColor3f(r2, g2, b2);
    glNormal3f(1, 0, 0);

    glVertex3f(0.5, -0.5, -0.5);
    glVertex3f(0.5, 0.5, -0.5);
    glVertex3f(0.5, 0.5, 0.5);
    glVertex3f(0.5, -0.5, 0.5);

    /* Left */
    glNormal3f(-1, 0, 0);

    glVertex3f(-0.5, -0.5, 0.5);
    glVertex3f(-0.5, 0.5, 0.5);
    glVertex3f(-0.5, 0.5, -0.5);
    glVertex3f(-0.5, -0.5, -0.5);

    /* Top */
    glColor3f(r1 + 0.1, g1 + 0.1, b1 + 0.1);
    glNormal3f(0, 1, 0);

    glVertex3f(0.5, 0.5, 0.5);
    glVertex3f(0.5, 0.5, -0.5);
    glVertex3f(-0.5, 0.5, -0.5);
    glVertex3f(-0.5, 0.5, 0.5);

    /* Bottom */
    glColor3f(0.0, 0.0, 0.0);
    glNormal3f(0, -1, 0);

    glVertex3f(0.5, -0.5, -0.5);
    glVertex3f(0.5, -0.5, 0.5);
    glVertex3f(-0.5, -0.5, 0.5);
    glVertex3f(-0.5, -0.5, -0.5);

    glEnd();

}

// Drawing the box that holds objects
void drawOpenBox() {
    /* Front */
    glBegin(GL_QUADS);
    glColor3f(1.0, 0.8, 0.0);
    glVertex3f(0.5, -0.5, -0.5);
    glVertex3f(0.5, 0.5, -0.5);
    glVertex3f(-0.5, 0.5, -0.5);
    glVertex3f(-0.5, -0.5, -0.5);

    /* Back */
    glColor3f(1.0, 0.5, 0.0);
    glVertex3f(0.5, -0.5, 0.5);
    glVertex3f(0.5, 0.5, 0.5);
    glVertex3f(-0.5, 0.5, 0.5);
    glVertex3f(-0.5, -0.5, 0.5);

    /* Right */
    glColor3f(1.0, 0.7, 0.0);
    glVertex3f(0.5, -0.5, -0.5);
    glVertex3f(0.5, 0.5, -0.5);
    glVertex3f(0.5, 0.5, 0.5);
    glVertex3f(0.5, -0.5, 0.5);

    /* Left */
    glColor3f(1.0, 0.4, 0.0);
    glVertex3f(-0.5, -0.5, 0.5);
    glVertex3f(-0.5, 0.5, 0.5);
    glVertex3f(-0.5, 0.5, -0.5);
    glVertex3f(-0.5, -0.5, -0.5);

    /* Bottom */
    glColor3f(1.0, 0.1, 0.0);
    glVertex3f(0.5, -0.5, -0.5);
    glVertex3f(0.5, -0.5, 0.5);
    glVertex3f(-0.5, -0.5, 0.5);
    glVertex3f(-0.5, -0.5, -0.5);

    glEnd();

}

// Drawing the table here for organization
void drawTable() {
    // Table top
    glPushMatrix();
    glTranslatef(0, -0.1, 0);
    glScalef(0.8, 0.05, 0.6);
    drawCube(0.0, 0.5, 0.0, 0.5, 0.5, 0.0);
    glPopMatrix();

    // Front left leg
    glPushMatrix();
    glTranslatef(-0.38, -0.32, -0.28);
    glScalef(0.04, 0.4, 0.04);
    drawCube(0.0, 0.5, 0.0, 0.5, 0.5, 0.0);
    glPopMatrix();

    // Front right leg
    glPushMatrix();
    glTranslatef(0.38, -0.32, -0.28);
    glScalef(0.04, 0.4, 0.04);
    drawCube(0.0, 0.5, 0.0, 0.5, 0.5, 0.0);
    glPopMatrix();

    // Back left leg
    glPushMatrix();
    glTranslatef(-0.38, -0.32, 0.28);
    glScalef(0.04, 0.4, 0.04);
    drawCube(0.0, 0.5, 0.0, 0.5, 0.5, 0.0);
    glPopMatrix();

    // Back right leg
    glPushMatrix();
    glTranslatef(0.38, -0.32, 0.28);
    glScalef(0.04, 0.4, 0.04);
    drawCube(0.0, 0.5, 0.0, 0.5, 0.5, 0.0);
    glPopMatrix();

}
// ---------------------------------------------------------------------------------------

// Draw the room
void drawRoom() {
    // The room is currently blue

    /* Back */
    glBegin(GL_POLYGON);
    glColor3f(0.0, 0.5, 1.0);
    glVertex3f(0.5, -0.5, 0.5);
    glVertex3f(0.5, 0.5, 0.5);
    glVertex3f(-0.5, 0.5, 0.5);
    glVertex3f(-0.5, -0.5, 0.5);
    glEnd();
    /* Left */
    glBegin(GL_POLYGON);
    glColor3f(0.0, 0.4, 1.0);
    glVertex3f(-0.5, -0.5, 0.5);
    glVertex3f(-0.5, 0.5, 0.5);
    glVertex3f(-0.5, 0.5, -0.5);
    glVertex3f(-0.5, -0.5, -0.5);
    glEnd();
    /* Bottom */
    glBegin(GL_POLYGON);
    glColor3f(0.0, 0.0, 1.0);
    glVertex3f(0.5, -0.5, -0.5);
    glVertex3f(0.5, -0.5, 0.5);
    glVertex3f(-0.5, -0.5, 0.5);
    glVertex3f(-0.5, -0.5, -0.5);
    glEnd();
}

// Very simple laptop
void drawLaptop() {
    // Screen
    glPushMatrix();
    glTranslatef(-0.3, 0.05, 0.242);
    glScalef(0.18, 0.15, 0.01);
    drawCube(0.3, 0.3, 0.3, 0.9, 0.9, 0.9);
    glPopMatrix();

    // Top
    glPushMatrix();
    glTranslatef(-0.3, 0.045, 0.25);
    glScalef(0.2, 0.2, 0.02);
    drawCube(0.8, 0.8, 0.8, 0.9, 0.9, 0.9);
    glPopMatrix();

    // Base
    glPushMatrix();
    glTranslatef(-0.3, -0.05, 0.15);
    glScalef(0.2, 0.02, 0.2);
    drawCube(0.6, 0.6, 0.6, 0.9, 0.9, 0.9);
    glPopMatrix();
}

void drawChair() {
    // Seat
    glPushMatrix();
    glTranslatef(-0.5, -0.3, 0);
    glScalef(0.3, 0.025, 0.3);
    drawCube(0.0, 0.1, 0.0, 0.1, 0.1, 0.0);
    glPopMatrix();

    // Front right leg
    glPushMatrix();
    glTranslatef(-0.39, -0.4, -0.13);
    glScalef(0.03, 0.22, 0.03);
    drawCube(0.0, 0.1, 0.0, 0.1, 0.1, 0.0);
    glPopMatrix();

    //Back right leg
    glPushMatrix();
    glTranslatef(-0.63, -0.4, -0.13);
    glScalef(0.03, 0.22, 0.03);
    drawCube(0.0, 0.1, 0.0, 0.1, 0.1, 0.0);
    glPopMatrix();

    // Front left leg
    glPushMatrix();
    glTranslatef(-0.39, -0.4, 0.14);
    glScalef(0.03, 0.22, 0.03);
    drawCube(0.0, 0.1, 0.0, 0.1, 0.1, 0.0);
    glPopMatrix();

    //Back left leg
    glPushMatrix();
    glTranslatef(-0.63, -0.4, 0.14);
    glScalef(0.03, 0.22, 0.03);
    drawCube(0.0, 0.1, 0.0, 0.1, 0.1, 0.0);
    glPopMatrix();
}

void drawSphere(float radius) {
    for (int j = 0; j < 360; j++) {
        glRotatef(j, 0, 1, 0);
        glBegin(GL_LINE_LOOP);
        for (int i = 0; i < 360; i++) {
            float degInRad = i * (3.14159 / 180);
            glVertex2f(cos(degInRad) * radius, sin(degInRad) * radius);
        }
        glEnd();
    }
}

void drawPyramid(float scale) {
    glScalef(scale, scale, scale);
    glBegin(GL_TRIANGLES);
    // Front
    glColor3f(0.5, 0.0, 0.5);
    glVertex3f(0.0f, 1.0f, 0.0f);
    glVertex3f(-1.0f, -1.0f, 1.0f);
    glVertex3f(1.0f, -1.0f, 1.0f);

    // Right
    glColor3f(0.5, 2.0, 0.5);
    glVertex3f(0.0f, 1.0f, 0.0f);
    glVertex3f(1.0f, -1.0f, 1.0f);
    glVertex3f(1.0f, -1.0f, -1.0f);

    // Back
    glColor3f(0.5, 0.0, 0.5);
    glVertex3f(0.0f, 1.0f, 0.0f);
    glVertex3f(1.0f, -1.0f, -1.0f);
    glVertex3f(-1.0f, -1.0f, -1.0f);

    // Left
    glColor3f(0.5, 2.0, 0.5);
    glVertex3f(0.0f, 1.0f, 0.0f);
    glVertex3f(-1.0f, -1.0f, -1.0f);
    glVertex3f(-1.0f, -1.0f, 1.0f);

    glEnd();

    glBegin(GL_QUADS);
    // bottom?

    glVertex3f(0.5, -0.5, -0.5);
    glVertex3f(0.5, -0.5, 0.5);
    glVertex3f(-0.5, -0.5, 0.5);
    glVertex3f(-0.5, -0.5, -0.5);

    glEnd();

}

// ---------------------------------------------------------------------------------------

// CLOCK STUFF
void DrawCircle(float cx, float cy, float r, int num_segments) {
    glBegin(GL_LINE_LOOP);
    glColor3f(0.0f, 0.0f, 0.0f);
    for (int i = 0; i < num_segments; i++)
    {
        float theta = 2.0f * 3.1415926f * i / num_segments; //get the current angle
        float x = r * cosf(theta);  //calculate the x component
        float y = r * sinf(theta);  //calculate the y component
        glVertex2f(x + cx, y + cy); //output vertex
    }
    glEnd();
}

void DrawMarks() {
    glPointSize(25);
    glBegin(GL_POINTS);
    glColor3f(0.7f, 0.0f, 1.0f);

     // when origin is 0,0
    glVertex2i(0, 300);    // 12
    glVertex2i(300, 0);    // 3
    glVertex2i(0, -300);    // 6
    glVertex2i(-300, 0);    // 9
    glEnd();
}

void Seconds(int s) {
    glPushMatrix();
    glRotated((double)-6 * s, 0, 0, 1);
    glColor3f(1.0f, 0.0f, 0.0f);
    glLineWidth(2);
    glBegin(GL_LINES);
    glVertex2f(0, 0);
    glVertex2f(0, 0.9);
    glEnd();
    glPopMatrix();
}

void Minutes(int m) {
    glPushMatrix();
    glRotated((double)-6 * m, 0, 0, 1);
    glColor3f(0.0f, 1.0f, 0.0f);
    glLineWidth(6);
    glBegin(GL_LINES);
    glVertex2f(0, 0);
    glVertex2f(0, 0.7);
    glEnd();
    glPopMatrix();
}

void Hours(int h, int m) {
    glPushMatrix();
    glRotated((double)(-30 * h + m * 0.5), 0, 0, 1);
    glColor3f(0.0f, 0.0f, 1.0f);
    glLineWidth(10);
    glBegin(GL_LINES);
    glVertex2f(0, 0);
    glVertex2f(0, 0.5);
    glEnd();
    glPopMatrix();
}

void drawClock() {
    int seconds, minutes, hours;

    // Update clock
    {
        time_t current_time = time(NULL);
        struct tm* local_time = localtime(&current_time);
        seconds = local_time->tm_sec;
        minutes = local_time->tm_min;
        hours = local_time->tm_hour;
    }

    // Draw clock
    {
        glLineWidth(2);
        DrawCircle(0, 0, 1, 100);
        DrawMarks();
        Seconds(seconds);
        Minutes(minutes);
        Hours(hours, minutes);

    }
}

// ---------------------------------------------------------------------------------------

// Drawing the open box and it's objects
void drawObjects() {
    // Where the key events take place

    x = fmax(x, 0.0);
    x = fmin(x, 0.4);

    z = fmax(z, -0.3);
    z = fmin(z, 0.3);

    glPushMatrix();
    // Drawing laptop here so it doesnt rotate or move like box
    drawLaptop();

    // Rotate the box and all its objects together
    glTranslatef(x, 0, z);
    glRotatef(angle, 0, 1, 0);

    // Box
    glPushMatrix();
    glTranslatef(0, -0.045, 0);
    glScalef(0.3, 0.05, 0.3);
    drawOpenBox();
    glPopMatrix();

    // Flashlight
    glPushMatrix();
    glTranslatef(-0.04, -0.04, 0.08);
    glRotatef(90, 1, 0, 0);
    glRotatef(90, 0, 0, 1);
    glScalef(0.1, 0.1, 0.1);
    drawPyramid(0.2);
    glPopMatrix();

    glPushMatrix();
    glTranslatef(-0.08, -0.04, 0.08);
    glRotatef(90, 0, 0, 1);
    glScalef(0.015, 0.06, 0.015);
    drawCube(0.5, 0.0, 0.5, 0.5, 0.2, 0.5);
    glPopMatrix();

    // Block stack
    glPushMatrix();
    glTranslatef(0.08, -0.02, 0.08);
    glScalef(0.04, 0.05, 0.04);
    drawCube(1.0, 0.0, 1.0, 1.0, 0.5, 1.0);
    glPopMatrix();

    glPushMatrix();
    glTranslatef(0.09, -0.02, 0.03);
    glScalef(0.04, 0.05, 0.04);
    drawCube(0.0, 0.0, 1.0, 0.0, 0.0, 0.5);
    glPopMatrix();

    glPushMatrix();
    glTranslatef(0.088, 0.02, 0.05);
    glScalef(0.04, 0.05, 0.04);
    drawCube(0.0, 1.0, 1.0, 0.0, 0.5, 1.0);
    glPopMatrix();

    // Snowman
    glPushMatrix();     // bottom
    glColor3f(1.0, 1.0, 1.0);
    glTranslatef(-0.08, -0.03, -0.08);
    glScalef(0.3, 0.3, 0.3);
    drawSphere(0.15);
    glPopMatrix();

    glPushMatrix();     // middle
    glColor3f(1.0, 1.0, 1.0);
    glTranslatef(-0.08, 0.04, -0.08);
    glScalef(0.3, 0.4, 0.3);
    drawSphere(0.11);
    glPopMatrix();

    glPushMatrix();     // top
    glColor3f(1.0, 1.0, 1.0);
    glTranslatef(-0.08, 0.11, -0.08);
    glScalef(0.3, 0.4, 0.3);
    drawSphere(0.05);
    glPopMatrix();
    

    glPopMatrix();
}

// Drawing everything in the scene
void drawScene() {

    glMatrixMode(GL_MODELVIEW);
    glLoadIdentity();
    gluLookAt(0, 0, 0, centerX, centerY, centerZ, 0, 1, 0);              // Camera 
    glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

    glPushMatrix();

    // ROOM
    glPushMatrix();
    glTranslatef(0.05, 0.0, -0.14);
    glScalef(1.7, 1.0, 1.6);
    drawRoom();
    glPopMatrix();

    // CLOCK
    glPushMatrix();
    glTranslatef(0.0, 0.25, 0.65);
    glScalef(0.15, 0.15, 1.0);
    drawClock();
    glPopMatrix();

    // -----------------------------------------------------------------------------------------------
    // Move the table and everything near
    glTranslatef(0 + xTable, 0, 0 + zTable);

    // Rotate the table and everything near
    glRotatef(0 + angle_table, 0, 1, 0);

    // Box + stuff on table
    drawObjects();

    // Drawing the table
    drawTable();

    // Drawing the chairs
    // Chair to left of table
    drawChair();

    // Chair behind table
    glTranslatef(0.5, 0, 0.35);
    drawChair();

    glPopMatrix();

    glFlush();
}

void toggle_light(GLenum index) {
#ifdef ENABLE_LIGHTING
    GLenum light = GL_LIGHT0 + index;
    lights_enabled[index] ? glDisable(light) : glEnable(light);
    lights_enabled[index] = !lights_enabled[index];
#endif
}

void set_light(GLenum index, GLfloat lx, GLfloat ly, GLfloat lz, GLfloat r, GLfloat g, GLfloat b, GLfloat a) {
    GLfloat light0_pos[] = { lx, ly, lz, 1.0 };
    GLfloat diffuse0[] = { r, g, b, a };
    GLfloat ambient0[] = { 1.0, 1.0, 1.0, 1.0 };
    GLfloat specular0[] = { 1.0, 1.0, 1.0, 1.0 };

    GLenum light = GL_LIGHT0 + index;
    glLightfv(light, GL_POSITION, light0_pos);
    glLightfv(light, GL_DIFFUSE, diffuse0);
    glLightfv(light, GL_AMBIENT, ambient0);
    glLightfv(light, GL_SPECULAR, specular0);

    toggle_light(index);
}

int main(int argc, char* argv[])
{
    // Initializing SDL
    SDL_Init(SDL_INIT_EVERYTHING);
    SDL_GL_SetAttribute(SDL_GL_CONTEXT_PROFILE_MASK, SDL_GL_CONTEXT_PROFILE_COMPATIBILITY);
    SDL_GL_SetAttribute(SDL_GL_CONTEXT_MAJOR_VERSION, 2);
    SDL_GL_SetAttribute(SDL_GL_CONTEXT_MINOR_VERSION, 1);

    // Creating SDL Window
    SDL_Window* window = SDL_CreateWindow("OpenGL", 100, 100, SCREEN_WIDTH, SCREEN_HEIGHT, SDL_WINDOW_OPENGL);
    if (!window)
    {
        printf("Cannot create the sdl window: %s", SDL_GetError());
        return -1;
    }
    // Creating GL context for the window, it is required for any gl functions to work
    SDL_GLContext context = SDL_GL_CreateContext(window);
    if (!context)
    {
        printf("Cannot create OpenGL context, probably the requested version of OpenGL is not supported on your machine.");
        printf("SDL ERROR: %s", SDL_GetError());
        return -1;
    }

    glViewport(0, 0, (GLsizei)SCREEN_WIDTH, (GLsizei)SCREEN_HEIGHT);

    glMatrixMode(GL_PROJECTION);
    glLoadIdentity();
    glMatrixMode(GL_MODELVIEW);     //between -1 and 1
    glLoadIdentity();

    glClearColor(1.0f, 1.0f, 1.0f, 0.0f); // Set clear color to white

    SDL_Event windowEvent;

    glEnable(GL_DEPTH_TEST);

#ifdef ENABLE_LIGHTING
    set_light(0, 4, 4, -20, 0.4, 0.4, 0.4, 1);      // light 1
    set_light(1, 2, 12, -15, 0.9, 0, 0, 1);         // light 2
    set_light(2, 2, 8, -15, 0.5, 0.2, 0, 1);        // light 3
    glEnable(GL_COLOR_MATERIAL);
    glEnable(GL_LIGHTING);
#endif

    while (1)
    {
        if (SDL_PollEvent(&windowEvent))
        {
            if (windowEvent.type == SDL_QUIT) break;
            if (windowEvent.type == SDL_KEYUP && windowEvent.key.keysym.sym == SDLK_ESCAPE) {
                break;
            }
            if (windowEvent.type == SDL_KEYDOWN) {      // Only move on key press
                switch (windowEvent.key.keysym.sym) {
                    // Moving box + objects
                case SDLK_a:
                    x -= 0.1;
                    break;

                case SDLK_d:
                    x += 0.1;
                    break;

                case SDLK_w:
                    z += 0.1;
                    break;

                case SDLK_s:
                    z -= 0.1;
                    break;

                    // Rotation of box + objects
                case SDLK_q:    // LEFT
                    angle += 5;
                    break;

                case SDLK_e:    // RIGHT
                    angle -= 5;
                    break;

                    // Moving table + objects
                case SDLK_j:
                    xTable -= 0.1;
                    break;

                case SDLK_l:
                    xTable += 0.1;
                    break;

                case SDLK_i:
                    zTable += 0.1;
                    break;

                case SDLK_k:
                    zTable -= 0.1;
                    break;

                    // Rotation of table
                case SDLK_u:    // LEFT
                    angle_table += 5;
                    break;

                case SDLK_o:    // RIGHT
                    angle_table -= 5;
                    break;

                case SDLK_c:
                    centerX = 0.3;       // Camera (Default)
                    centerY = 0.8;
                    centerZ = -1;
                    break;

                case SDLK_v:
                    centerX = 0.3;       // Camera 2
                    centerY = 0.4;
                    centerZ = -1;
                    break;

                case SDLK_b:
                    centerX = 0.3;       // Camera 3
                    centerY = 0.8;
                    centerZ = -0.5;
                    break;

                case SDLK_n:
                    centerX = 4;       // Camera 4
                    centerY = 0.8;
                    centerZ = -1;
                    break;

                    // LIGHTS
                case SDLK_1:
                    toggle_light(0);
                    break;
                case SDLK_2:
                    toggle_light(1);
                    break;
                case SDLK_3:
                    toggle_light(2);
                    break;

                default:
                    break;
                }
            }

        }

        glClear(GL_COLOR_BUFFER_BIT);

        drawScene();

        SDL_GL_SwapWindow(window);
    }

    SDL_GL_DeleteContext(context);
    SDL_Quit();
    return 0;
}
