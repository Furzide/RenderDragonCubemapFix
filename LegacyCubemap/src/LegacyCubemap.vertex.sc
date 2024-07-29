$input a_position, a_texcoord0
$output v_texcoord0

#include <bgfx_shader.sh>

uniform mat4 CubemapRotation;

void main() {
	//thanks to yamarin for helping me figure out how to change y pos
    vec3 pos = a_position.xyz;
    if (CubemapRotation[0][2] == 0.0)
    pos.y -= -0.205; // y position!!! -0.205 matches java edition perfectly.
    gl_Position = mul(u_modelViewProj, mul(CubemapRotation, vec4(pos, 1.0)));
    v_texcoord0 = a_texcoord0;
}
